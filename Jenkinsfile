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
    
     // dir('SpringBoot-Angular8/Demo_SpringBoot_JPA_CRUD 4') {
      
        //sh 'mvn -B -Demo_SpringBoot_JPA_CRUD 4 clean build package' 
       
        
        dir ('SpringBoot-Angular8/Angular8-Client') {
        
				bat 'npm install'
				bat 'ng build'
		}
      //}
      
    } catch(error) {
      //slackSend message: color:'danger'
    }
  }
}

  
