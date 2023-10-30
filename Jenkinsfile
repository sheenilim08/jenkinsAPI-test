def gv

pipeline {
    agent any 
    tools{
        nodejs "node18"
    }
    stages {

        stage("increment version"){
            steps {
                script{
                    echo "increment app version..."
                    sh 'npm version patch'
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