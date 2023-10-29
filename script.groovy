def buildImage(){
    echo "building dev api docker image..."
    withCredentials([usernamePassword(credentialsId:'dockerhub-cred',passwordVariable:'PASS',usernameVariable:'USER')]){
        sh 'docker build -t incredgolf/golf:api-1:0 .'
        sh 'echo $PASS |docker login -u $USER --password-stdin'
        sh 'docker push incredgolf/golf:api-1:0'
    }
    
}

def deployAPI(){
    echo "deploying dev api..."
}

def testAPI(){
    echo "testing dev api..."
}

return this