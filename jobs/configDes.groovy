job('Checkout Repositorio Des') {
    scm {
        git{
                remote {
                github('jcintas/ejercicioSemilla', 'ssh')
                credentials('38233920-c9bf-4604-a74d-de8f701868e3')
            }
             branch('desarrollo')
        }
    }
    
}
