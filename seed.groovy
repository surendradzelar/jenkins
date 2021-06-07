folder('CI Pipelines'){
    displayName ('CI Pipelines')
    description ('CI Pipelines')
}

pipelineJob('CI Pipelines/frontend-ci'){
    configure { flowdefinition ->
    flowdefinition / 'properties' << 'org.jenkinsci.plugins.workflow.job.properties.PipelineTriggersJobProperty' {
        //'triggers' {
            //'hudson.triggers.SCMTrigger' {
                //'spec'('* * * * 1-5')
                //'ignorePostCommitHooks'(false)
              //  }
            //}
        }
            flowdefinition << delegate.'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps') {
                'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git') {
                    'userRemoteConfigs' {
                        'hudson.plugins.git.UserRemoteConfig' {
                            'url'('https://github.com/zssurendra01/frontend.git')
                             'refspec'('\'+refs/tags/*\':\'refs/remotes/origin/tags/*\'')


                       }
                    }
                    'branches' {
                        'hudson.plugins.git.BranchSpec' {
                            'name'('*/tags/*')
                        }
                    }
                }
                'scriptPath'('jenkinsfile')
                'lightweight'(true)
            }
        }
    }

pipelineJob('CI Pipelines/users-ci'){
     configure { flowdefinition ->
            flowdefinition / 'properties' << 'org.jenkinsci.plugins.workflow.job.properties.PipelineTriggersJobProperty' {
               //'triggers' {
            //'hudson.triggers.SCMTrigger' {
                //'spec'('* * * * 1-5')
                //'ignorePostCommitHooks'(false)
              //  }
            //}
           }
            flowdefinition << delegate.'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps') {
                'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git') {
                    'userRemoteConfigs' {
                        'hudson.plugins.git.UserRemoteConfig' {
                            'url'('https://github.com/zssurendra01/users.git')
                            'refspec'('\'+refs/tags/*\':\'refs/remotes/origin/tags/*\'')

                                   }
                    }
                    'branches' {
                        'hudson.plugins.git.BranchSpec' {
                            'name'('*/tags/*')
                        }
                    }
                }
                'scriptPath'('jenkinsfile')
                'lightweight'(true)
            }
        }
    }

pipelineJob('CI Pipelines/login-ci'){
     configure { flowdefinition ->
            flowdefinition / 'properties' << 'org.jenkinsci.plugins.workflow.job.properties.PipelineTriggersJobProperty' {
               //'triggers' {
            //'hudson.triggers.SCMTrigger' {
                //'spec'('* * * * 1-5')
                //'ignorePostCommitHooks'(false)
              //  }
            //}
           }
            flowdefinition << delegate.'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps') {
                'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git') {
                    'userRemoteConfigs' {
                        'hudson.plugins.git.UserRemoteConfig' {
                            'url'('https://github.com/zssurendra01/login.git')
                            'refspec'('\'+refs/tags/*\':\'refs/remotes/origin/tags/*\'')

                                   }
                    }
                    'branches' {
                        'hudson.plugins.git.BranchSpec' {
                            'name'('*/tags/*')
                        }
                    }
                }
                'scriptPath'('jenkinsfile')
                'lightweight'(true)
            }
        }
    }




pipelineJob('CI Pipelines/todo-ci'){
     configure { flowdefinition ->
            flowdefinition / 'properties' << 'org.jenkinsci.plugins.workflow.job.properties.PipelineTriggersJobProperty' {
               //'triggers' {
            //'hudson.triggers.SCMTrigger' {
                //'spec'('* * * * 1-5')
                //'ignorePostCommitHooks'(false)
              //  }
            //}
           }
            flowdefinition << delegate.'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps') {
                'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git') {
                    'userRemoteConfigs' {
                        'hudson.plugins.git.UserRemoteConfig' {
                            'url'('https://github.com/zssurendra01/todo.git')
                            'refspec'('\'+refs/tags/*\':\'refs/remotes/origin/tags/*\'')

                                   }
                    }
                    'branches' {
                        'hudson.plugins.git.BranchSpec' {
                            'name'('*/tags/*')
                        }
                    }
                }
                'scriptPath'('jenkinsfile')
                'lightweight'(true)
            }
        }
    }   
