pipeline {
  agent any
  stages {
    stage('Initialize') {
      parallel {
        stage('Initialize') {
          steps {
            echo 'inicio do pipeline'
          }
        }
        stage('') {
          steps {
            git 'https://github.com/Hirondina/IGRP-Framework.git'
          }
        }
      }
    }
    stage('Build') {
      parallel {
        stage('Build') {
          steps {
            build 'Teste'
          }
        }
        stage('') {
          steps {
            archiveArtifacts 'my-app-1.0-SNAPSHOT'
          }
        }
      }
    }
    stage('Test') {
      steps {
        junit 'pom.xml'
      }
    }
  }
}