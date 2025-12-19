pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Build application'
            }
        }
        stage('Test') {
            steps {
                echo 'Test application'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploy application'
            }
        }
    }
    post {
        always {
            emailext(
                body: 'summary',
                subject: 'pipeline status',
                to: 'om.pokar@voicenova.ai'
            )
        }
    }
}
