
def call (Map params = [ : ]) {
    def args = [
        Nexus = '172.31.6.224', 
    ]

    args << params

    pipeline {
        agent any 

        environment{
            COMPONENT = "${args.COMPONENT}"
        }
        stages {
            stage('seeing artifacts') {
                steps {
                  sh '''
                    echo ${COMPONENT}
                    zip frontend.zip *
                    '''
            }
        }
            stage ('Uploading artifacts to nexus') {
                steps {
                  sh '''
                   curl -v -u admin:zelar123 --upload-file frontend.zip http://172.31.6.224:8081/repository/frontend/frontend.zip
                '''

            }
        }
    }
}

    
}