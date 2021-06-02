folder('CI Pipelines'){
    displayName ('CI Pipelines')
    description ('CI Pipelines')
}


for (i in 0..count) {
   def j=component[i]
    pipelineJob('CI-Pipelines/frontend-ci') {
        configure { flowdefinition ->
            flowdefinition / 'properties' << 'org.jenkinsci.plugins.workflow.job.properties.PipelineTriggersJobProperty' {
                'triggers' {
                   'hudson.triggers.SCMTrigger' {
                        'spec'('* * * * 1-5')
                        'ignorePostCommitHooks'(false)
                    }
                }
            }
            flowdefinition << delegate.'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps') {
                'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git') {
                    'userRemoteConfigs' {
                        'hudson.plugins.git.UserRemoteConfig' {
                            'url'('https://github.com/zssurendra01/'+j+'.git')
                            'refspec'('\'+refs/tags/*\':\'refs/remotes/origin/tags/*\'')
                        }
                    }
                    'branches' {
                        'hudson.plugins.git.BranchSpec' {
                            'name'('*/main')
                        }
                    }
                }
                'scriptPath'('jenkinsfile')
                'lightweight'(true)
            }
        }
    }
}
//def COMPONENT =["frontend","users","login","todo"];

for (com in 0..count) {
   def con=component[i]
    pipelineJob('CI-Pipelines/users-ci') {
        configure { flowdefinition ->
            flowdefinition / 'properties' << 'org.jenkinsci.plugins.workflow.job.properties.PipelineTriggersJobProperty' {
                'triggers' {
                   'hudson.triggers.SCMTrigger' {
                        'spec'('* * * * 1-5')
                        'ignorePostCommitHooks'(false)
                    }
                }
            }
            flowdefinition << delegate.'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps') {
                'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git') {
                    'userRemoteConfigs' {
                        'hudson.plugins.git.UserRemoteConfig' {
                            'url'('https://github.com/zssurendra01/'+con+'.git')
                            'refspec'('\'+refs/tags/*\':\'refs/remotes/origin/tags/*\'')
                        }
                    }
                    'branches' {
                        'hudson.plugins.git.BranchSpec' {
                            'name'('*/main')
                        }
                    }
                }
                'scriptPath'('jenkinsfile')
                'lightweight'(true)
            }
        }
    }
}
//def COMPONENT =["frontend","users","login","todo"];

for (com in 0..count) {
   def con=component[i]
    pipelineJob('CI-Pipelines/login-ci') {
        configure { flowdefinition ->
            flowdefinition / 'properties' << 'org.jenkinsci.plugins.workflow.job.properties.PipelineTriggersJobProperty' {
                'triggers' {
                   'hudson.triggers.SCMTrigger' {
                        'spec'('* * * * 1-5')
                        'ignorePostCommitHooks'(false)
                    }
                }
            }
            flowdefinition << delegate.'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps') {
                'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git') {
                    'userRemoteConfigs' {
                        'hudson.plugins.git.UserRemoteConfig' {
                            'url'('https://github.com/zssurendra01/'+con+'.git')
                            'refspec'('\'+refs/tags/*\':\'refs/remotes/origin/tags/*\'')
                        }
                    }
                    'branches' {
                        'hudson.plugins.git.BranchSpec' {
                            'name'('*/main')
                        }
                    }
                }
                'scriptPath'('jenkinsfile')
                'lightweight'(true)
            }
        }
    }
}

//def COMPONENT =["frontend","users","login","todo"];

for (com in 0..count) {
   def con=component[i]
    pipelineJob('CI-Pipelines/todo-ci') {
        configure { flowdefinition ->
            flowdefinition / 'properties' << 'org.jenkinsci.plugins.workflow.job.properties.PipelineTriggersJobProperty' {
                'triggers' {
                   'hudson.triggers.SCMTrigger' {
                        'spec'('* * * * 1-5')
                        'ignorePostCommitHooks'(false)
                    }
                }
            }
            flowdefinition << delegate.'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps') {
                'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git') {
                    'userRemoteConfigs' {
                        'hudson.plugins.git.UserRemoteConfig' {
                            'url'('https://github.com/zssurendra01/'+con+'.git')
                            'refspec'('\'+refs/tags/*\':\'refs/remotes/origin/tags/*\'')
                        }
                    }
                    'branches' {
                        'hudson.plugins.git.BranchSpec' {
                            'name'('*/main')
                        }
                    }
                }
                'scriptPath'('jenkinsfile')
                'lightweight'(true)
            }
        }
    }
}
