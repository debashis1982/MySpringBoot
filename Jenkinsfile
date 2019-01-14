pipeline {
    agent any
    stages {
        stage ('Initialize') {
            steps {
                sh '''
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
            }
        }
        stage('UnitTest') {
            steps {
                echo 'Unit Testing..'
            }
        }
        stage('FunctionalTest') {
            steps {
                echo 'Functional Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
