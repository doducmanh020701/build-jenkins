pipeline {
    agent any
    tools {
        maven 'my-maven'
    }
    environment {
        POSTGRES_ROOT_LOGIN = credentials('postgres')
    }
    stages {
        stage('Build step maven') {
            steps {
                sh "mvn --version"
                sh "java --version"
                sh "mvn clean package -Dmaven.test.failure.ignore=true"
            }
        }
        stage('Pushing Images') {
            steps {
                withDockerRegistry(credentialsId: 'docker_hub', url: 'https://index.docker.io/v1/'){
                    sh 'docker build -t doducmanh/springboot .'
                    sh 'docker push doducmanh/springboot'
                }
            }
        }
        stage('Deploy postgres sql'){
            steps{
                echo "Deploying and cleaning sql"
                sh 'docker images pull postgres'
                sh 'docker network create dev || echo "this network exist" '
                sh 'docker container stop postgres_container || echo "this container does not exist" '
                sh 'docker rm postgres_container || echo "this container remove" '
                sh 'docker volume rm postgres_data || echo "no volume" '

                sh 'docker volume create postgres_data'
                sh 'docker run --name postgres_container -e POSTGRES_PASSWORD=postgres -d -p 5432:5432 -v postgres_data:/var/lib/postgresql/data postgres'
                sh 'sleep 15'
                sh 'docker exec -i postgres_container postgres --user=postgres --password=${POSTGRES_ROOT_LOGIN} < script'
            }
        }
        stage('Deploy spring boot to dev') {
            steps {
                echo "Deploying and cleaning"
                sh 'docker images pull doducmanh/springboot'
                sh 'docker container stop doducmanh-springboot || echo "this container does not exits"'
                sh 'docker rm doducmanh-springboot || echo "this remove container" '
                sh 'docker network create dev || echo "this network exist" '
                sh 'docker container run -d --rm --name doducmanh-springboot -p 8081:8080 --network dev doducmanh/springboot'
            }
        }
    }
}
