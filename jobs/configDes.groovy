job('Checkout Repositorio Des') {
    scm {
        git{
            remote {
                url('https://github.com/jcintas/ejercicioSemilla.git')
            }
             branch('desarrollo')
        }
    }
}

job('Construccion Des') {
    jdk('JDK8')
    
    steps {
        maven {
            goals('clean')
            goals('verify')
            mavenOpts('-Xms256m')
            mavenOpts('-Xmx512m')
            localRepository(LocalRepositoryLocation.LOCAL_TO_WORKSPACE)
            properties(skipTests: true)
            mavenInstallation('maven-3.6.2')
            rootPOM('./../Checkout Repositorio Des/')
        }
    }
    
    triggers {
        upstream('Checkout Repositorio Des', 'SUCCESS')
    }
    
}

job('Sonar') {
    steps {
        batchFile{'mvn sonar:sonar ' + 
          '-f ./pom.xml ' +
          '-Dsonar.projectKey=cursoCImaven2 ' +
          '-Dsonar.language=java ' +
          '-Dsonar.sources=. ' +
          '-Dsonar.tests=. ' +
          '-Dsonar.java.binaries=./target/classes ' +
          '-Dsonar.test.inclusions=**/*Test*/** ' +
          '-Dsonar.exclusions=**/*Test*/**'
          }
        }
    }
    
    triggers {
        upstream('Construccion Des', 'SUCCESS')
    }
}



