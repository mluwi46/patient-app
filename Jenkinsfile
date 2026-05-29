pipeline {
    agent any
    tools {
        jdk 'DefaultJDK'
        git 'Default'
    }
    stages {
        stage('Check JDK') {
            steps {
                bat 'java -version'
                bat 'javac -version'
            }
        }
        stage('Build') {
            steps {
                bat 'javac -d bin src\\PatientApp.java'
            }
        }
        stage('Package JAR') {
            steps {
                bat 'jar cfe PatientApp.jar PatientApp -C bin .'
            }
        }
        stage('Run Console App') {
            steps {
                bat 'java -cp bin PatientApp'
            }
        }
        stage('Test') {
            steps {
                bat 'java -cp bin org.junit.runner.JUnitCore PatientAppTest'
            }
        }
        stage('Deploy') {
            steps {
                bat 'copy PatientApp.jar C:\\deploy\\PatientApp.jar'
                bat 'docker build -t smartmed/patient-app .'
                bat 'docker run -d --name patient-app smartmed/patient-app'
            }
        }
    }
    post {
        success {
            archiveArtifacts artifacts: 'PatientApp.jar', fingerprint: true
        }
    }
}
