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
                echo 'Building jar..'
                sh 'mvn -Dmaven.test.failure.ignore=true install'
            }
        }
        stage('DeployDockerImage') {
            steps{
                echo 'Login to ECR'
                sh 'aws ecr get-login --no-include-email --region us-west-2'
                echo 'Docker Build for ECR'
                sh 'docker build -t myspringboot .'
                echo 'Docker tag image'
                sh 'docker tag myspringboot:latest 961578000206.dkr.ecr.us-east-1.amazonaws.com/myspringboot:latest'
                echo 'Docker push'
                sh 'docker push 961578000206.dkr.ecr.us-east-1.amazonaws.com/myspringboot:latest'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
