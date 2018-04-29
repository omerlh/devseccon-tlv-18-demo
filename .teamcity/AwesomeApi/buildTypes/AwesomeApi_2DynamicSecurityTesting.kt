package AwesomeApi.buildTypes

import AwesomeApi.buildTypes.AwesomeApi_Build
import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.buildSteps.exec
import jetbrains.buildServer.configs.kotlin.v2017_2.triggers.finishBuildTrigger

object AwesomeApi_2DynamicSecurityTesting : BuildType({
    uuid = "9152e28b-2280-4233-a627-850c81ddc9ae"
    id = "AwesomeApi_2DynamicSecurityTesting"
    name = "2. Dynamic Security Testing"

    vcs {
        root(AwesomeApi.vcsRoots.AwesomeApi_GitGitlabExampleComRootAwesomeApiGitRefsHeadsMaster)

    }

    steps {
        exec {
            path = "./scripts/run_security_tests.sh"
        }
    }

    triggers {
        finishBuildTrigger {
            buildTypeExtId = AwesomeApi_Build.id
            branchFilter = "+:+"
        }
    }

    dependencies {
        dependency(AwesomeApi.buildTypes.AwesomeApi_Build) {
            snapshot {
                onDependencyFailure = FailureAction.FAIL_TO_START
            }

            artifacts {
                buildRule = lastSuccessful()
                artifactRules = "zap.zip!**=>zap/session"
            }
        }
    }
})
