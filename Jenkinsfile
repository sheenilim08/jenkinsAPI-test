def gv

pipeline {
    agent any 
    stages {
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