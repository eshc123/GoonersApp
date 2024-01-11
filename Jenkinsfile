pipeline {
  agent any
  stages {
    stage('assembleDebug') {
      steps {
        sh '`` `./gradlew assembleDebug --stacktrace` ``'
      }
    }

    stage('print') {
      steps {
        echo 'print'
      }
    }

  }
}