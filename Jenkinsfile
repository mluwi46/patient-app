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
                bat 'javac -d bin src\\*.java'
            }
        }
        stage('Test') {
            steps {
                bat 'java -cp bin org.junit.runner.JUnitCore PatientAppTest'
            }
        }
    }
}
