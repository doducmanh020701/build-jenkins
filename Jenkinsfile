pipeline{
    agent any
    tools{
        maven 'my_maven'
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/doducmanh020701/build-jenkins']])
                sh 'mvn clean install -DskipTests'
            }
        }
        stage('Build Docker'){
            steps{
                sh 'docker build -t doducmanh/build-users:v1.0.0 .'
            }
        }
        stage('Push Docker'){
            steps{
                withCredentials([string(credentialsId: 'dockertext', variable: 'dockerhub')]) {
                    sh 'docker login -u doducmanh020701@gmail.com -p ${dockerhub}'
                }
                sh 'docker push doducmanh/build-users:v1.0.0'
            }
        }
        stage('Pull and run images Docker'){
            steps{
                sh 'docker-compose -f docker-compose.dev.yml up --build'
            }
        }
    }
}