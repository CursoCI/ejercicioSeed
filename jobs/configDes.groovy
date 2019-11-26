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

mavenJob('Sonar2') {
        goals('sonar:sonar')
        rootPOM('./../Checkout Repositorio Des/pom.xml')
        mavenOpts('-Dsonar.projectKey=cursoCImaven2')
        mavenOpts('-Dsonar.language=java')
        mavenOpts('-Dsonar.sources=.')
        mavenOpts('-Dsonar.tests=. ')
        mavenOpts('-Dsonar.java.binaries=./target/classes')
        mavenOpts('-Dsonar.test.inclusions=**/*Test*/** ')
        mavenOpts('-Dsonar.exclusions=**/*Test*/**')
        mavenInstallation('maven-3.6.2')
    
    triggers {
        upstream('Construccion Des', 'SUCCESS')
    }
}




