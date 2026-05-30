pipeline {
    agent any
    tools {
        jdk 'DefaultJDK'
        maven 'DefaultMaven'
    }

    environment {
        DEPLOY_DIR = 'C:\\deploy'
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Fetching latest code from GitHub...'
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo 'Running Maven clean and compile...'
                bat 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                echo 'Executing JUnit tests...'
                bat 'mvn test'
            }
        }

        stage('Package') {
            steps {
                echo 'Packaging JAR file...'
                bat 'mvn package'
            }
        }

        stage('Run App') {
            steps {
                echo 'Running PatientApp JAR...'
                bat 'java -jar target\\patient-app-1.0-SNAPSHOT.jar'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying PatientApp to local directory...'
                bat "if not exist %DEPLOY_DIR% mkdir %DEPLOY_DIR%"
                bat "copy target\\patient-app-1.0-SNAPSHOT.jar %DEPLOY_DIR%\\PatientApp.jar"
                // Uncomment these lines once Docker is ready:
                // bat 'docker build -t smartmed/patient-app .'
                // bat 'docker run -d --name patient-app smartmed/patient-app'
            }
        }
    }

    post {
        success {
            echo '✅ Build, test, package, run, and deploy completed successfully!'
            archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
        }
        failure {
            echo '❌ Build failed — please check the logs for details.'
        }
    }
}

