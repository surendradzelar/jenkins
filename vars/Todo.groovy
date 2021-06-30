 def call(Map params = [:] ) {
     def args = [
        NEXUS_IP : '172.31.15.207', 
     ]
     args << params
    pipeline {
        agent {
            label "${args.SLAVE_LABEL}"
        }
    
        environment {
            COMPONENT ="${args.COMPONENT}"
            NEXUS_IP = "${args.NEXUS_IP}"
            PROJECT_NAME = "${args.PROJECT_NAME}"
            SLAVE_LABEL = "${args.SLAVE_LABEL}"
            APP_TYPE    = "${args.APP_TYPE}"
        }
        stages {
            stage('Build code & install dependencies') {
                steps {
                    script {
                        build = new nexus()
                        build.code_build("${APP_TYPE}","${COMPONENT}")
                    }
                }

            }
            stage('Prepare Artifacts') {

                steps {
                    script {
                        prepare = new nexus()
                        prepare.make_artifacts("${APP_TYPE}","${COMPONENT}")
                    }
                }
            }

            stage('Upload Artifacts') {
                steps {
                    script {
                        prepare = new nexus()
                        prepare.nexus(COMPONENT)
                    }

                }
            }
            stage('Depoly dev env') {
                
                steps{
                    sh 'build job : 'deployment pipeline', 
                    parameters: [string(name:'ENV',value:'dev') string(name:'COMPONENT', value:'${COMPONENT}') string(name:'version', value:"${get_branch_exec}")]
                }
            }
        }
    }

 }