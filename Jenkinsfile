// TODO - complete basic template
pipeline {
    agent any

    tools {
        jdk 'openjdk-17'
    }

    stages {
        stage ('Verify') {
            sh 'mvn verify'
        }

        stage ('Analysis') {
            environment {
                scannerHome = tool 'sonarScanner'
                token = credentials(sonar)
            }

            steps {
                withSonarQubeEnv('sonarServer') {
                    sh '''
                    ${scannerHome}/bin/sonar-scanner \
                    -Dsonar.login=${token}
                    '''
                }

                timeout(time: 5, unit: 'MINUTES') {
                    script {
                        def qualitygate = waitForQualityGate()
                        if (qualitygate.status != 'OK') {
                            currentBuild.result = 'UNSTABLE'
                            unstable('SonarQube Quality Gate failed')
                        }
                    }
                }
            }
        }

        stage ('Build') {
            when {
                branch 'master'
            }

            steps {
                sh 'docker build --tag java-api-rest .'
            }
        }

        stage ('Archive') {
            when {
                branch 'master'
            }

            steps {
                sh 'docker save --output java-api-rest.tar java-api-rest'
            }
        }
    }

    post {
        always {
            sh 'docker rmi --force java-api-rest || true'
            sh 'docker rmi $(docker images --filter dangling=true --quiet) || true'
        }
    }
}
