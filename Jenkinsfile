pipeline{
    agent any
    stages{
        stage('Jenkis Departamento'){
            steps{
                echo 'Jankins departamento interface'
            }
        }
        stage('Build Interface'){
            steps{
                build job: 'classroom.departamento', wait: true
            }
        }

        stage('Build'){
            steps{
                sh 'mvn clean package'
            }
        }

        stage('Build Image'){

            steps{
                script{
                    departamento = docker.build("c0d8/departamento:${env.BUILD_ID}", "-f Dockerfile .")
                }
            }

        }

        stage('Push Image'){
            steps{
                script{
                    docker.withRegistry('https://registry.hub.docker.com', 'dockerhub-credential'){
                        departamento.push("${env.BUILD_ID}")
                        departamento.push("latest")
                    }
                }
            }
        }
       
    }
}