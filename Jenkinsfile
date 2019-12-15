pipeline {

  agent any

  stages {

    stage('Build') {

      steps {

        echo 'build finished'

        bat 'mvn clean'

        echo 'maven clean successfully...'

        bat 'mvn install -DskipTests=true -Dmaven.javadoc.skip=true -B -V'

        echo 'maven install successfully...'

        bat 'mvn package'

        echo 'maven package successfully...'

      }

    }

    stage('Build Docker Image') {

      steps {

        echo "Starting building..."

          withCredentials([usernamePassword(credentialsId: 'docker-hub', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {

          echo '$USERNAME + %USERNAME%'

          echo '$PASSWORD + %PASSWORD%'

          bat 'docker login -u %USERNAME% -p %PASSWORD%'

          bat 'docker image build -t yunduandenirtw/search .'

          bat 'docker push yunduandenirtw/search:latest'

        }   

      }

    }

  }

  post {

    always {

      echo 'build and deploy finished'

    }



    failure {

      echo 'build failed'

    }



    success {

      echo 'deploy successfully'

    }

  }

}