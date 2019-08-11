node('master') {
  stage('import') {
    try {
    
      git url:'https://github.com/sofani/SpringBoot-Server.git'
    
      
    } catch(error) {
      //slackSend message:{env.BUILD_NUMBER} color:'danger'
    }
  }
  
  stage('build') {
    try {
    
      dir('SpringBoot-Server') {
      
        sh 'mvn -B -SpringBoot-Server clean build package' 
       
        
        dir ('SpringBoot-Server/Client-Angular8') {
        
				bat 'npm install'
				bat 'ng build'
			}
      }
      
    } catch(error) {
      //slackSend message: color:'danger'
    }
  }
}

  
