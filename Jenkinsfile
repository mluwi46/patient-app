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
        stage('Run') {
            steps {
                bat 'java -cp bin PatientApp'
            }
        }
    }
}
