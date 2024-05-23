Write-Output "Starting SurrealDB..."
Start-Process "surreal.exe" -ArgumentList "start", "memory", "-A", "--auth", "--user", "root", "--pass", "root"
Start-Sleep -Seconds 5

Write-Output "SurrealDB started."
Write-Output "Starting Quarkus..."
Start-Process "cmd" -ArgumentList "/c", "quarkus dev"
