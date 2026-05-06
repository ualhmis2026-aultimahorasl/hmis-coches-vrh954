pipeline {
    agent any

    tools {
        maven "Default Maven"
        jdk   "Default JDK"
    }

    stages {

        stage('Git fetch') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/ualhmis2026-aultimahorasl/hmis-coches-vrh954.git'
            }
        }

        stage('Compile, Test, Package') {
            steps {
                sh "mvn clean package"
            }
            post {
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts artifacts: '**/target/*.jar', allowEmptyArchive: true
                    jacoco(
                        execPattern:      '**/target/jacoco.exec',
                        classPattern:     '**/target/classes',
                        sourcePattern:    '**/src/',
                        exclusionPattern: '**/test/'
                    )
                    publishCoverage adapters: [jacocoAdapter('**/target/site/jacoco/jacoco.xml')]
                }
            }
        }

        stage('Static Analysis') {
            steps {
                sh "mvn site"
            }
            post {
                success {
                    recordIssues enabledForFailure: true, tool: checkStyle()
                    recordIssues enabledForFailure: true, tool: pmdParser()
                    recordIssues enabledForFailure: true, tool: cpd()
                    recordIssues enabledForFailure: true, tool: spotBugs()
                }
            }
        }

        stage('Dependency-Check') {
            steps {
                sh "mvn org.owasp:dependency-check-maven:check"
            }
            post {
                success {
                    dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
                }
            }
        }

        stage('Documentation') {
            steps {
                sh "mvn javadoc:javadoc javadoc:aggregate"
            }
            post {
                success {
                    publishHTML(target: [
                        reportName: 'Maven Site',
                        reportDir:  'target/site/es',
                        reportFiles:'index.html',
                        keepAll:    false,
                        alwaysLinkToLastBuild: true,
                        allowMissing: true
                    ])
                    publishHTML(target: [
                        reportName: 'Javadoc',
                        reportDir:  'target/site/es/apidocs',
                        reportFiles:'index.html',
                        keepAll:    false,
                        alwaysLinkToLastBuild: true,
                        allowMissing: true
                    ])
                }
            }
        }
    }
}
