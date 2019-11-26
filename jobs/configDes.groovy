pipelineJob('Checkout Repositorio Des') {
    definition {
        scm {
                git('https://github.com/jcintas/ejercicioSemilla.git', 'desarrollo'){
                        remote {
                        github('account/repo', 'ssh')
                        credentials('38233920-c9bf-4604-a74d-de8f701868e3')
                    }
                }
            }
    }
}
