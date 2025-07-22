# Script: build-all.ps1 
# Purpose: Maven build for tf-boycott-service and tf-sanction-service, and prepare app.jar

$BASE_PATH = "C:\Code\redhat_hackathon_bamoe"

# Define the service modules to build
$SERVICE_MODULES = @("tf-boycott-service", "tf-sanction-service")

# Step: Build service modules
foreach ($SERVICE in $SERVICE_MODULES) {
    $SERVICE_PATH = "$BASE_PATH\$SERVICE"
    Write-Host ""
    Write-Host "=== Building $SERVICE ==="
    Set-Location $SERVICE_PATH
    mvn clean install -DskipTests

    if ($LASTEXITCODE -ne 0) {
        Write-Host "Maven build failed for $SERVICE"
        continue
    }

    $JAR_FILE = Get-ChildItem -Path "$SERVICE_PATH\target" -Filter "*-service-*.jar" | Select-Object -First 1
    if ($null -ne $JAR_FILE) {
        Copy-Item $JAR_FILE.FullName -Destination "$SERVICE_PATH\target\app.jar" -Force
        Write-Host "Copied $($JAR_FILE.Name) to target/app.jar for $SERVICE"
    } else {
        Write-Host "No service JAR file found for $SERVICE"
    }
}

Write-Host ""
Write-Host "Maven build complete for all service modules"
