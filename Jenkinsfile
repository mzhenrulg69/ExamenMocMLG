pipeline {
    agent any

      tools {

            maven 'Maven-3.9'
            jdk 'jdk17'
      }
     environment {
            PROJECT_VERSION = '1.0.0'
        }

        stages {
            // Stage 1: Checkout
            stage('Checkout') {
                steps {
                    echo 'Realizando checkout del proyecto...'
                    // El checkout automático ya se hizo antes
                }
            }

            // Stage 2: Build
            stage('Build') {
                steps {
                    echo 'Limpiando y compilando el proyecto...'
                    bat 'mvn clean compile'
                }
            }

            // Stage 3: Test
            stage('Test') {
                steps {
                    echo 'Ejecutando tests...'
                    bat 'mvn test'
                }
            }

            // Stage 4: Package
            stage('Package') {
                steps {
                    echo 'Empaquetando proyecto...'
                    bat 'mvn package -DskipTests'
                }
            }

            // Stage 5: Move jar
            stage('Move jar') {
                steps {
                    script {
                        echo 'Eliminando directorio versiones....'
                        bat '''
                            @echo off
                            if exist versiones (
                                rmdir /s /q versiones
                            )
                        '''
                    }
                }
                post {
                    success {
                        echo 'Se crea el directorio versiones con la última versión de la api'
                        bat '''
                            @echo off
                            mkdir versiones
                            copy target\\*.jar versiones\\
                            dir versiones
                        '''
                    }
                }
            }
        }

        post {
            always {
                echo 'Pipeline completada'
            }
            success {
                echo '✅ Pipeline ejecutada con éxito!'
            }
            failure {
                echo '❌ Pipeline falló'
            }
        }
}