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
                    s "mvn test"
                }
            }
            stage("Build the docker image") {
                steps{
                sh "docker build --tag disiko/tp-docker:1.0.0 ."
                }
            }
            
        }
        post{
            failure{
                emailext body: ’Ce Build $BUILD_NUMBER a échoué’,
                recipientProviders:[requestor()], subject: ’build’, to:
                ’zdamienemmanuel@gmail.com’ 
                } 
        }
}