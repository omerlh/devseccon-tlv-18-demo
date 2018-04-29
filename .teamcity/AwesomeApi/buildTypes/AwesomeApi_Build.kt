package AwesomeApi.buildTypes

import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.buildSteps.exec
import jetbrains.buildServer.configs.kotlin.v2017_2.triggers.vcs

object AwesomeApi_Build : BuildType({
    uuid = "32676c2b-2e36-4bca-ae9a-9f745513ca75"
    id = "AwesomeApi_Build"
    name = "1. Black Box Tests"

    artifactRules = "zap/session => zap.zip"

    vcs {
        root(AwesomeApi.vcsRoots.AwesomeApi_GitGitlabExampleComRootAwesomeApiGitRefsHeadsMaster)

        cleanCheckout = true
    }

    steps {
        exec {
            path = "./scripts/run_tests.sh"
        }
        exec {
            path = "./scripts/teardown_tests.sh"
        }
    }

    triggers {
        vcs {
        }
    }
})
