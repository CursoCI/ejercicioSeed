pipelineJob('Checkout Repositorio Des') {
    definition {
        cpsScm {
            scm {
                git('https://github.com/jcintas/ejercicioSemilla.git', 'desarrollo')
            }
        }
    }
}
