@Library('my-shared-library') _

pipeline {
    agent {
        kubernetes {
            yaml mavenPodYaml(
                 useCache: false,
                 image: 'crpi-whdz2l2sopzelm2i-vpc.cn-beijing.personal.cr.aliyuncs.com/kangvai/maven:3.9-eclipse-temurin-17'
            )
        }
    }
    options {
        timeout(time: 15, unit: 'MINUTES')
        buildDiscarder(logRotator(numToKeepStr: '20'))
    }
    stages {
        stage('拉取代码') {
            steps {
                checkout scm
            }
        }
        stage('编译') {
            steps {
                container('maven') {
                    sh 'mvn -B -DskipTests clean compile'
                }
            }
        }
        stage('单元测试') {
            steps {
                container('maven') {
                    sh 'mvn -B test'
                }
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        stage('打包') {
            steps {
                container('maven') {
                    sh 'mvn -B -DskipTests package'
                }
            }
        }
        stage('归档产物') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
    }
    post {
        success { echo '✅ 构建成功' }
        failure { echo '❌ 构建失败' }
    }
}
