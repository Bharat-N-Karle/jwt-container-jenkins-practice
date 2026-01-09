pipeline {
    agent any

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/Bharat-N-Karle/jwt-container-jenkins-practice.git'
            }
        }

        stage('Build JAR') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t jwt-image:1.0 .'
            }
        }

        stage('Stop Old Container') {
            steps {
                sh '''
                docker stop jwt-container || true
                docker rm jwt-container || true
                '''
            }
        }

        stage('Run New Container') {
            steps {
                sh '''
                docker run -d \
                --name jwt-container \
                -p 8080:8080 \
                jwt-image:1.0
                '''
            }
        }
    }
}
