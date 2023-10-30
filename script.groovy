def buildImage(){
    echo "building dev api docker image..."
    withCredentials([usernamePassword(credentialsId:'dockerhub-cred',passwordVariable:'PASS',usernameVariable:'USER')]){
        sh "docker build -t incredgolf/golf:$IMAGE_NAME ."
        sh 'echo $PASS |docker login -u $USER --password-stdin'
        sh "docker push incredgolf/golf:$IMAGE_NAME"
    }
    
}

def deployAPI(){
    echo "deploying dev api..."
    echo "deploying dev......"
}

def testAPI(){
    echo "testing dev api..."
}

return this
