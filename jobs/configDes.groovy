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
        bat 'dir ./../Checkout Repositorio Des/'
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



