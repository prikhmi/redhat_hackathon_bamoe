# Set environment variables
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
    $SERVICE_NAME = Split-Path -Leaf $SERVICE_PATH
    $IMAGE_NAME = $SERVICE_NAME.ToLower()

    # Step 1: Build JAR using Maven
    Write-Host "Running mvn clean install for $SERVICE_NAME..."
    Set-Location $SERVICE_PATH
    mvn clean install -DskipTests

    if ($LASTEXITCODE -ne 0) {
        Write-Error "Maven build failed for $SERVICE_NAME"
        continue
    }

    # Step 2: Copy generated JAR as app.jar
    $JAR_FILE = Get-ChildItem -Path target -Filter "*-service-*.jar" | Select-Object -First 1

    if ($null -eq $JAR_FILE) {
        Write-Error "No JAR file found for $SERVICE_NAME"
        continue
    }

    Copy-Item $JAR_FILE.FullName -Destination "target/app.jar" -Force
    Write-Host "Copied $($JAR_FILE.Name) to target/app.jar"

    # Step 3: Build container image using Podman
    Write-Host "Building container image for $IMAGE_NAME..."
    podman build -f $DOCKERFILE_PATH -t "$IMAGE_NAME:latest" $CONTEXT_PATH

    if ($LASTEXITCODE -ne 0) {
        Write-Error "Image build failed for $IMAGE_NAME"
        continue
    }

    # Step 4: Tag and push image to OpenShift internal registry
    $FULL_TAG = "$REGISTRY/$NAMESPACE/$IMAGE_NAME:latest"
    podman tag "$IMAGE_NAME:latest" "$FULL_TAG"
    Write-Host "Pushing image to OpenShift registry..."
    podman push "$FULL_TAG"
}

# Step 5: Apply runtime YAMLs for deployment
Write-Host ""
Write-Host "=== Deploying Runtime YAMLs ==="

$BOYCOTT_YAML = "$DEPLOYMENT_PATH\boycott-runtime.yaml"
$SANCTION_YAML = "$DEPLOYMENT_PATH\sanction-runtime.yaml"

if (Test-Path $BOYCOTT_YAML) {
    oc apply -f $BOYCOTT_YAML -n $NAMESPACE
    Write-Host "Applied boycott-runtime.yaml"
} else {
    Write-Host "boycott-runtime.yaml not found: $BOYCOTT_YAML"
}

if (Test-Path $SANCTION_YAML) {
    oc apply -f $SANCTION_YAML -n $NAMESPACE
    Write-Host "Applied sanction-runtime.yaml"
} else {
    Write-Host "sanction-runtime.yaml not found: $SANCTION_YAML"
}

Write-Host ""
Write-Host "=== All steps completed ==="
