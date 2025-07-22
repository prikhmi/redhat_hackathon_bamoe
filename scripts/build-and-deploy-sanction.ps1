# Set the service directory path
$servicePath = "C:\Code\rh_bamoe\tf-sanction-service"
$dockerfilePath = "$servicePath\src\main\docker\Dockerfile.jvm"
$contextPath = $servicePath

# Navigate to the service path
Set-Location $servicePath

# Find the generated jar file
$jarFile = Get-ChildItem -Path target -Filter "*-service-*.jar" | Select-Object -First 1

if ($null -eq $jarFile) {
    Write-Error "No matching JAR file found in target/"
    exit 1
}

# Copy the jar to known name for Dockerfile
Copy-Item $jarFile.FullName -Destination "target/app.jar" -Force
Write-Output "Copied $($jarFile.Name) as app.jar"

# Build image with podman
podman build -f $dockerfilePath -t tf-sanction-service:latest $contextPath
