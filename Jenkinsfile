pipeline{
agent any
  stages{
    stage('Build'){
      steps{
        echo "Building the code ....."
        bat "mvn clean"
      }
    }
    stage('Test'){
      steps{
        echo "Testing the code ....."
        bat "mvn install"
      }
    }
    stage('Compile'){
      steps{
        echo "Compiling the code ....."
        bat "mvn compile"
      }
    }
    stage('Deploy'){
      steps{
        echo "Deploying the code ....."
      }
    }
  }
}
