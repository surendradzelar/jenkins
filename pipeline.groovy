import hudson.model.*
import hudson.EnvVars
import groovy.json.JsonSlurperClassic
import groovy.json.JsonBuilder
import groovy.json.JsonOutput
import groovy.json.*
import java.net.URL

def call(String COMPONENT) {
    pipeline {
    agent {
        label "SLAVE"
    }
    environment {
        COMPONENT = COMPONENT
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
                echo ${COMPONENT}
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