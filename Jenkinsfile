pipeline {
    agent any
    stages {
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
