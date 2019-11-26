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
            goals('install')
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

mavenJob('Analisis Sonar') {
        goals('sonar:sonar')
        rootPOM('./../Checkout Repositorio Des/pom.xml')
        goals('-Dsonar.projectKey=cursoCImaven2')
        goals('-Dsonar.language=java')
        goals('-Dsonar.sources=.')
        goals('-Dsonar.tests=. ')
        goals('-Dsonar.java.binaries=./target/classes')
        goals('-Dsonar.test.inclusions=**/*Test*/** ')
        goals('-Dsonar.exclusions=**/*Test*/**')
        mavenInstallation('maven-3.6.2')
    
    triggers {
        upstream('Construccion Des', 'SUCCESS')
    }
}

job('Test unitarios') {
    customWorkspace('./workspace/Checkout Repositorio Des')
    steps {
        maven {
            goals('test')
            mavenOpts('-Xms256m')
            mavenOpts('-Xmx512m')
            mavenInstallation('maven-3.6.2')
        }
    }
    
    publishers {
        archiveJunit('**/target/surefire-reports/*.xml')
    }
    
    triggers {
        upstream('Construccion Des', 'SUCCESS')
    }
}




