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


mavenJob('Construcción Des') {
    jdk('JDK8')
    
    triggers {
        upstream('Checkout Repositorio Des', 'SUCCESS')
    }
    goals('clean install verify')
}
