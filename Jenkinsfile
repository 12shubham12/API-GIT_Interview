pipeline {
    agent any
    parameters {
        choice(
            name: 'ENVIRONMENT',
            choices: ['ST', 'SIT', 'UAT'],
            description: 'Choose the environment to deploy'
        )
    }
    environment {
        ENV_FILE = "env/${params.ENVIRONMENT.toLowerCase()}.env"
    }
    stages {
        stage('Checkout') {
            steps {
                // Checkout code from source control
                checkout scm
            }
        }
        stage('Load Environment') {
            steps {
                script {
                    // Read the selected environment file and set environment variables
                    def envProps = readProperties file: "${ENV_FILE}"
                    envProps.each { key, value ->
                        env."${key}" = value
                    }
                }
            }
        }
        stage('Build') {
            steps {
                echo "Building for environment: ${params.ENVIRONMENT}"
                // Example: print the loaded BASE_URL
                echo "BASE_URL: ${env.BASE_URL}"
                // Add your build steps here, e.g., Maven build
                sh 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                echo "Testing for environment: ${params.ENVIRONMENT}"
                // Add your test steps here
                sh 'mvn test'
            }
        }
        stage('Deploy') {
            steps {
                echo "Deploying to environment: ${params.ENVIRONMENT}"
                // Add your deploy steps here
            }
        }
    }
}