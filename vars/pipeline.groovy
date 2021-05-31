@Library('todo') _
import hudson.model.*
import hudson.EnvVars
import groovy.json.JsonSlurperClassic
import groovy.json.JsonBuilder
import groovy.json.JsonOutput
import groovy.json.*
import java.net.URL

def pipeline () {
  pipeline {
    agent any
    stages {
        stage('seeing artifacts') {
            steps {
                sh '''
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