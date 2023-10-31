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
                    sh 'git config --global user.name "jenkins"'
                    sh 'git config --global user.email "jenkins@example.com"'
                }
            }
        }

        stage("increment version"){
            steps {
                script{
                    echo "increment app version..."
                    sh 'cat package.json'
                    sh 'npm version patch --no-git-version'
                    sh 'cat package.json'
                    def matcher = readFile('package.json') =~ /"version": "([^"]+)"/
                    def version = matcher[0][1]
                    env.IMAGE_NAME = "$version-$BUILD_NUMBER"
                    echo "build number is $version....."
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

    stage("commit version update"){
        steps {
            script{
                gv.commitBackToGit()
            }
        }
    }
    }
}