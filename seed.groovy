folder('CI Pipelines'){
    displayName ('CI Pipelines')
    description ('CI Pipelines')
}
pipelineJob('CI Pipelines/frontend-ci'){
     configure { flowdefinition ->
            flowdefinition << delegate.'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps') {
                'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git') {
                    'userRemoteConfigs' {
                        'hudson.plugins.git.UserRemoteConfig' {
                            'url'('https://github.com/zssurendra01/jenkins.git')

                                   }
                    }
                    'branches' {
                        'hudson.plugins.git.BranchSpec' {
                            'name'('*/main')
                        }
                    }
                }
                'scriptPath'('seed.groovy')
                'lightweight'(true)
            }
        }
    }

pipelineJob('CI Pipelines/users-ci'){
     configure { flowdefinition ->
            flowdefinition << delegate.'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps') {
                'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git') {
                    'userRemoteConfigs' {
                        'hudson.plugins.git.UserRemoteConfig' {
                            'url'('https://github.com/zssurendra01/jenkins.git')

                                   }
                    }
                    'branches' {
                        'hudson.plugins.git.BranchSpec' {
                            'name'('*/main')
                        }
                    }
                }
                'scriptPath'('seed.groovy')
                'lightweight'(true)
            }
        }
    }

pipelineJob('CI Pipelines/login-ci'){
     configure { flowdefinition ->
            flowdefinition << delegate.'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps') {
                'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git') {
                    'userRemoteConfigs' {
                        'hudson.plugins.git.UserRemoteConfig' {
                            'url'('https://github.com/zssurendra01/jenkins.git')

                                   }
                    }
                    'branches' {
                        'hudson.plugins.git.BranchSpec' {
                            'name'('*/main')
                        }
                    }
                }
                'scriptPath'('seed.groovy')
                'lightweight'(true)
            }
        }
    }




pipelineJob('CI Pipelines/todo-ci'){
     configure { flowdefinition ->
            flowdefinition << delegate.'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps') {
                'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git') {
                    'userRemoteConfigs' {
                        'hudson.plugins.git.UserRemoteConfig' {
                            'url'('https://github.com/zssurendra01/jenkins.git')

                                   }
                    }
                    'branches' {
                        'hudson.plugins.git.BranchSpec' {
                            'name'('*/main')
                        }
                    }
                }
                'scriptPath'('seed.groovy')
                'lightweight'(true)
            }
        }
    }   
