pipeline{
    agent any
  
    
        stages{
            stage('git checkout'){
                steps{
                    git credentialsId:'d88b1d45-5d52-4dc6-947f-b1ba3c4f45f4', url:'https://github.com/disikoX/TP-Junit.git'
                }
            }
            
            
            stage('Build the application'){
                steps{
                    sh "mvn clean install"
                }
            }
            
            stage("Unit test Execution"){
                steps{
                    sh "mvn test"
                }
            }
            stage("Build the docker image") {
                steps{
                sh "docker build --tag disiko/tp-docker:1.0.0 ."
                }
            }
            
        }
}