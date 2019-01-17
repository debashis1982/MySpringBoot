pipeline {
    agent any
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "Build initialized by $(whoami)"
                    java -version
                    mvn --version
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                ''' 
            }
        }
        stage('Build') {
            steps {
                echo 'Building..'
                sh 'mvn -Dmaven.test.failure.ignore=true install'
                echo 'Building docker image'
                sh 'docker build -t myspringboot .'
                echo 'Tagging image'
                sh 'docker tag myspringboot:latest 961578000206.dkr.ecr.us-east-1.amazonaws.com/myeksecr:latest'
            }
        }
        stage('DeployDockerImage') {
            steps{
                echo 'Pushing docker image to ECR'
                sh 'docker push 961578000206.dkr.ecr.us-east-1.amazonaws.com/myeksecr:latest'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
