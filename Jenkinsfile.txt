pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'javac src/PatientApp.java'
            }
        }
        stage('Test') {
            steps {
                sh 'java -cp .:junit-4.13.2.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore PatientAppTest'
            }
        }
        stage('Deploy') {
            steps {
                sh 'scp src/PatientApp.class user@server:/apps/smartmed/'
            }
        }
    }
}
