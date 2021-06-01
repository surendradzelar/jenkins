def nexus(COMPONENT) {
    get_branch = "env | grep GIT_BRANCH | awk -F / '{print \$NF}' | xargs echo -n"
    def get_branch_exec=sh(returnStdout: true, script: get_branch)
    def FILENAME=COMPONENT+'-'+get_branch_exec+'.zip'
    command = "curl -f -v -u admin:zelar123 --upload-file ${FILENAME} http://172.31.8.211:8081/repository/${COMPONENT}/${FILENAME}"
    def execute_state = sh(returnStdout: true, script: command)
}
 def make_artifacts(APP_TYPE,COMPONENT) {
     get_branch = "env | grep GIT_BRANCH | awk -F / '{print \$NF}' | xargs echo -n"
     def get_branch_exec=sh(returnStdout: true, script: get_branch)
     println("abc${get_branch_exec}abc")
     def FILENAME=COMPONENT+'-'+get_branch_exec+'.zip'
    if(APP_TYPE == "NGINX" ) {
        command = " zip -r ${FILENAME} * "
        def execute_com= sh(returnStdout: true, script: command)
        print execute_com
    }
    else if(APP_TYPE == "NODEJS" ) {
        command = "zip -r ${FILENAME} node_modules server.js"
        def execute_com= sh(returnStdout: true, script: command)
        print execute_com

    }
    else if(APP_TYPE == "java" ) {
        command =  "cp target/*.jar ${FILENAME} * "
        def execute_com= sh(returnStdout: true, script: command)
        print execute_com
    }
    else if (APP_TYPE == "GOLANG") {
        command = "zip -r ${FILENAME} * "
        def execute_com= sh(returnStdout: true, script: command)
        print execute_com
    }
 }
def code_build(APP_TYPE,COMPONENT) {
    if(APP_TYPE == 'NODEJS') {
        command = "npm install"
        def execute_com= sh(returnStdout: true, script: command)
        print execute_com
    }
    else if(APP_TYPE == 'GOLANG') {
        command = " sudo apt-get update && wget -c https://dl.google.com/go/go1.14.2.linux-amd64.tar.gz -O - | sudo tar -xz -C /usr/local && export PATH=$PATH:/usr/local/go/bin  && go version  && git clone https://github.com/zelar-soft-todoapp/login.git  && sudo apt install go-dep && go get && go build"
        def execute_com = sh(returnStdout: true, script: command)
        print execute_com
    }
    else if(APP_TYPE == 'JAVA') {
        command = "sudo apt-get update && sudo apt-get install maven -y  && git clone https://github.com/zelar-soft-todoapp/users.git && cd users && mvn clean package && mv target/users-api-0.0.1.jar users.jar"
        def execute_com = sh(returnStdout: true, script: command)
        print execute_com
    }
    else if(APP_TYPE == "NGINX") {
        command = "npm install && npm run build"
        def execute_com = sh(returnStdout: true, script: command)
        print execute_com
    }
}