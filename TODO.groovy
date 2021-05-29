def call(){
    pipeline {
    agent {
        label "SLAVE"
    }
    stages {
        stage('Download ') {
            steps {
                sh '''
                 npm install
                 npm run build
                '''
            }
        }
        stage('seeing artifacts') {
            steps {
                sh '''
                zip -r frontend.zip *
                '''
            }
        }
        stage ('Uploading artifacts to nexus') {
            steps {
                script{
                    nexus
                }

            }
        }
    }
} 
}