pipeline {
    agent any
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "${java -version}"
                    echo "$(mvn --version)"
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                ''' 
            }
        }
        stage('Build') {
            steps {
                echo 'Building..'
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
