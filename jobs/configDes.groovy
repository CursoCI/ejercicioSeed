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


job('Construcción Desa') {
    jdk('JDK8')
    
    triggers {
        upstream('Checkout Repositorio Des', 'SUCCESS')
    }
    steps {
        maven {
            goals('clean')
            goals('verify')
            mavenOpts('-Xms256m')
            mavenOpts('-Xmx512m')
            localRepository(LocalRepositoryLocation.LOCAL_TO_WORKSPACE)
            properties(skipTests: true)
            mavenInstallation('maven-3.6.2')
        }
    }
}
