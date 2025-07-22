# deploy-image.ps1 - Plain PowerShell Script to Build and Push Images using Podman

# Variables
$NAMESPACE = "v-sharp"
$REGISTRY = "image-registry.openshift-image-registry.svc:5000"

# Services
$services = @("tf-boycott-service", "tf-sanction-service")

# Loop through each service
foreach ($service in $services) {
    Write-Host "Building image for $service..."

    # Build image
    podman build -f "$service\src\main\docker\Dockerfile" -t "$service:latest" "$service"

    # Tag image
    $fullTag = "$REGISTRY/$NAMESPACE/$service:latest"
    podman tag "$service:latest" "$fullTag"

    Write-Host "Pushing image to OpenShift internal registry..."
    podman push "$fullTag"
}

Write-Host "Image deployment complete."
