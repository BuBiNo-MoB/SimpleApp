pipeline {
    agent any
    environment {
        DOCKERHUB_CREDENTIALS = credentials('dockerhub-credentials')
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/BuBiNo-MoB/SimpleApp.git'
            }
        }
        stage('Build Application') {
            steps {
                script {
                    sh 'mvn clean package'
                }
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    sh 'docker build -t myapp .'
                }
            }
        }
        stage('Build and Push Docker Image') {
            steps {
                script {
                    docker.withRegistry('https://index.docker.io/v1/', 'dockerhub-credentials') {
                        def app = docker.build("bubinomob/simpleapp")
                        app.push("latest")
                    }
                }
            }
        }
        stage('Deploy') {
            steps {
                script {
                    ansiblePlaybook(
                        credentialsId: 'pass-ansible',
                        playbook: 'deploy.yml',
                        inventory: 'hosts'
                    )
                }
            }
        }
    }
    post {
        success {
            echo 'Build completed successfully!'
            slackSend(channel: '#jenkins-notifications', message: "Build succeeded for ${env.JOB_NAME} #${env.BUILD_NUMBER}!")
        }
        failure {
            echo 'Build failed!'
            slackSend(channel: '#jenkins-notifications', message: "Build failed for ${env.JOB_NAME} #${env.BUILD_NUMBER}!")
        }
        unstable {
            echo 'Build is unstable!'
            slackSend(channel: '#jenkins-notifications', message: "Build is unstable for ${env.JOB_NAME} #${env.BUILD_NUMBER}!")
        }
        changed {
            script {
                def buildStatus = currentBuild.currentResult
                if (buildStatus == 'SUCCESS') {
                    slackSend(channel: '#jenkins-notifications', message: "Build is back to normal for ${env.JOB_NAME} #${env.BUILD_NUMBER}!")
                }
            }
        }
    }
}
