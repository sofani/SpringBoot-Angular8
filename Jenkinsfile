node('master') {
  stage('import') {
    try {
    
      git url:'https://github.com/sofani/SpringBoot-Angular8.git'
    
      
    } catch(error) {
      //slackSend message:{env.BUILD_NUMBER} color:'danger'
    }
  }
  
  stage('build') {
    try {
    
      dir('SpringBoot-Angular8/Demo_SpringBoot_JPA_CRUD') {
      
        sh 'mvn -B -SpringBoot-Server clean build package' 
       
        
        dir ('SpringBoot-Angular8/Client-Angular8') {
        
				bat 'npm install'
				bat 'ng build'
			}
      }
      
    } catch(error) {
      //slackSend message: color:'danger'
    }
  }
}

  
