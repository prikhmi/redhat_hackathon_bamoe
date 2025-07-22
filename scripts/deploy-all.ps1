# deploy-all.ps1
# Purpose: Build container images using Podman and deploy them to OpenShift internal image registry

$BASE_PATH = "C:\Code\rh_bamoe"
$NAMESPACE = "v-sharp"
$REGISTRY = "image-registry.openshift-image-registry.svc:5000"
$DEPLOYMENT_PATH = "$BASE_PATH\deployment"
$SERVICES = @("tf-boycott-service", "tf-sanction-service")

foreach ($SERVICE in $SERVICES) {
    Write-Host ""
    Write-Host "=== Building and Deploying $SERVICE ==="

    $SERVICE_PATH = "$BASE_PATH\$SERVICE"
    $DOCKERFILE_PATH = "$SERVICE_PATH\src\main\docker\Dockerfile.jvm"
    $CONTEXT_PATH = $SERVICE_PATH
    $IMAGE_NAME = $SERVICE.ToLower()
    $LOCAL_TAG = "$IMAGE_NAME:latest"
    $FULL_TAG = "$REGISTRY/$NAMESPACE/$IMAGE_NAME:latest"

    # Step 1: Rename JAR to app.jar for Docker
    $jarSource = Get-ChildItem "$SERVICE_PATH\target" -Filter "*.jar" | Where-Object { $_.Name -notlike "*original*" } | Select-Object -First 1
    if ($jarSource) {
        Rename-Item -Path $jarSource.FullName -NewName "$SERVICE_PATH\target\app.jar" -Force
        Write-Host "Renamed $($jarSource.Name) to app.jar"
    } else {
        Write-Warning "No JAR found to rename in $SERVICE_PATH\target"
        continue
    }

    # Step 2: Build the image with Podman
    Write-Host "Building image for $IMAGE_NAME..."
    podman build -f $DOCKERFILE_PATH -t $LOCAL_TAG $CONTEXT_PATH
    if ($LASTEXITCODE -ne 0) {
        Write-Error "Image build failed for $IMAGE_NAME"
        continue
    }

    # Step 3: Tag and push image to OpenShift internal registry
    podman tag $LOCAL_TAG $FULL_TAG
    podman push $FULL_TAG
    if ($LASTEXITCODE -ne 0) {
        Write-Error "Image push failed for $IMAGE_NAME"
        continue
    }
}

# Step 4: Apply runtime YAMLs
Write-Host ""
Write-Host "=== Deploying Runtime YAMLs ==="

$RUNTIME_YAMLS = @("boycott-runtime.yaml", "sanction-runtime.yaml")

foreach ($yaml in $RUNTIME_YAMLS) {
    $yamlPath = "$DEPLOYMENT_PATH\$yaml"
    Write-Host "Applying $yamlPath"
    oc apply -f $yamlPath
    if ($LASTEXITCODE -ne 0) {
        Write-Warning "Failed to apply $yaml"
    }
}

Write-Host ""
Write-Host "=== All deployment steps completed ==="
