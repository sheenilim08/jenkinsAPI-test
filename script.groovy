def buildImage(){
    echo "building dev api docker image..."
    withCredentials([usernamePassword(credentialsId:'dockerhub-cred',passwordVariable:'PASS',usernameVariable:'USER')]){
        sh "docker build -t incredgolf/golf:${IMAGE_NAME} ."
        sh 'echo $PASS |docker login -u $USER --password-stdin'
        sh "docker push incredgolf/golf:${IMAGE_NAME}"
    }
    
}

def deployAPI(){
    echo "deploying dev api..."
    echo "deploying dev......"
}

def testAPI(){
    echo "testing dev api..."
}

def commitBackToGit(){
    echo "updating package.json in git..."
   withCredentials([usernamePassword(credentialsId:'github-creds',passwordVariable:'PASS',usernameVariable:'USER')]){
        sh 'git status'
        sh 'git branch'
        sh 'git config --list'
        sh "git remote set-url origin https://${USER}:${PASS}@github.com/IncredApplicationsPvtLtd/jenkinsAPI.git"
        sh "git add ."
        sh "git commit -m 'ci:version bump'"
        sh "git push origin HEAD:main"
    }
}

return this
