def gv

pipeline {
    agent any 
    tools{
        nodejs "node18"
    }
    stages {

        stage('configure git'){
            steps{
                script{
                    echo "configuirng git..."
                    sh 'git config --global user.name "phpnoida"'
                    sh 'git config --global user.email "amitrepublik@gmail.com"'
                }
            }
        }

        stage("increment version"){
            steps {
                script{
                    echo "increment app version..."
                    sh 'npm version patch'
                    def matcher = readFile('package.json') =~ /"version": "([^"]+)"/
                    def version = matcher[0][1]
                    env.IMAGE_NAME = "$version-$BUILD_NUMBER"
                    echo "build number is $version..."
                }
            }
        }
        stage("init"){
        steps {
            script {
                gv = load "script.groovy"
            }
        }
    }

    stage("test"){
        steps {
            script {
                gv.testAPI()
            }
        }

    }

    stage("build"){
        steps {
            script {
                gv.buildImage()
            }
        }
    }

    stage("deploy"){
        steps{
            script {
                gv.deployAPI()
            }
        }
    }
    }
}