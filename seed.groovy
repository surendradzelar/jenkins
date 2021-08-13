folder('ci-pipelines') {
  displayName('ci pipelines')
  description('ci pipelines')
}

def component = ["todo", "login","users","frontend"];

def count=(component.size()-1)
for (i in 0..count) {
  def j=component[i]
  pipelineJob("ci-pipelines/${j}-ci") {
    configure { flowdefinition ->
      flowdefinition / 'properties' << 'org.jenkinsci.plugins.workflow.job.properties.PipelineTriggersJobProperty' {
        //'triggers' {
          //'hudson.triggers.SCMTrigger' {
            //'spec'('*/2 * * * 1-5')
            //'ignorePostCommitHooks'(false)
          //}
        //}
      }
      flowdefinition << delegate.'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps') {
        'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git') {
          'userRemoteConfigs' {
            'hudson.plugins.git.UserRemoteConfig' {
              'url'('https://github.com/surendradzelar/'+j+'.git')
              'refspec'('\'+refs/tags/*\':\'refs/remotes/origin/tags/*\'')


            }
          }
          'branches' {
            'hudson.plugins.git.BranchSpec' {
              'name'('*/tags*')
            }
          }
        }
        'scriptPath'('jenkinsfile')
        'lightweight'(true)
      }
    }
  }
}





pipelineJob("DEPLOYMENT-PIPELINES") {
    configure { flowdefinition ->
      flowdefinition << delegate.'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps') {
        'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git') {
          'userRemoteConfigs' {
            'hudson.plugins.git.UserRemoteConfig' {
              'url'('https://github.com/surendradzelar/jenkins.git')
              'refspec'('\'+refs/tags/*\':\'refs/remotes/origin/tags/*\'')
            }
          }
          'branches' {
            'hudson.plugins.git.BranchSpec' {
              'name'('main')
            }
          }
        }
        'scriptPath'('jenkinsfile-deployment')
        'lightweight'(true)
      }
    }
  }







  folder('docker-pipelines') {
  displayName('docker pipelines')
  description('docker pipelines')
}

def component = ["todo", "login","users","frontend"];

def count=(component.size()-1)
for (i in 0..count) {
  def j=component[i]
  pipelineJob("docker-pipelines/${j}-ci") {
    configure { flowdefinition ->
      flowdefinition / 'properties' << 'org.jenkinsci.plugins.workflow.job.properties.PipelineTriggersJobProperty' {
        //'triggers' {
          //'hudson.triggers.SCMTrigger' {
            //'spec'('*/2 * * * 1-5')
            //'ignorePostCommitHooks'(false)
          //}
        //}
      }
      flowdefinition << delegate.'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps') {
        'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git') {
          'userRemoteConfigs' {
            'hudson.plugins.git.UserRemoteConfig' {
              'url'('https://github.com/surendradzelar/'+j+'.git')
              'refspec'('\'+refs/tags/*\':\'refs/remotes/origin/tags/*\'')


            }
          }
          'branches' {
            'hudson.plugins.git.BranchSpec' {
              'name'('*/tags*')
            }
          }
        }
        'scriptPath'('jenkinsfile-docker')
        'lightweight'(true)
      }
    }
  }
}