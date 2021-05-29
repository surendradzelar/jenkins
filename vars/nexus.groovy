def nexus()
{command = "curl -v -u admin:zelar123 --upload-file frontend.zip http://172.31.0.171:8081/repository/frontend/frontend1.zip"

def execute_state=sh(returnStdout: true, script: command)}