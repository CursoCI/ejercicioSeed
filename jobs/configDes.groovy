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
    
}
