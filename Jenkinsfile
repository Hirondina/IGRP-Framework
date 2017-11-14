pipeline {
  agent any
  stages {
    stage('Initialize') {
      steps {
        echo 'inicio do pipeline'
      }
    }
    stage('Build') {
      steps {
        archiveArtifacts 'my-app-1.0-SNAPSHOT'
      }
    }
    stage('Test') {
      steps {
        junit 'pom.xml'
      }
    }
  }
}