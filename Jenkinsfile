pipeline {
    agent any
    environment {
        AWS_ACCESS_KEY_ID = credentials('AWS_ACCESS_KEY_ID')
        AWS_SECRET_ACCESS_KEY = credentials('AWS_SECRET_ACCESS_KEY')
    }
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
                echo 'AWS Configure'
                sh 'aws configure set aws_access_key_id $AWS_ACCESS_KEY_ID'
                sh 'aws configure set aws_secret_access_key $AWS_SECRET_ACCESS_KEY'
                echo 'Login to ECR'
                sh '$(aws ecr get-login --no-include-email --region us-east-1)'
                echo 'Docker Build for ECR'
                sh 'docker build -t myeksecr .'
                echo 'Docker tag image'
                sh 'docker tag myeksecr:latest 961578000206.dkr.ecr.us-east-1.amazonaws.com/myeksecr:latest'
                echo 'Docker push'
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
