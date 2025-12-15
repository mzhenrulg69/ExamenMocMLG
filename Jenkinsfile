pipeline {
    agent any

    environment {
        PROJECT_VERSION = '1.0.0'
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Checkout del proyecto...'
            }
        }

        stage('Build') {
            steps {
                echo 'Compilando...'
                bat 'mvn clean compile'
            }
        }
    }
}