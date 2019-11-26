pipelineJob('example') {
    definition {
        cpsScm {
            scm {
                git('https://github.com/jcintas/ejercicioSemilla.git')
            }
        }
    }
}
