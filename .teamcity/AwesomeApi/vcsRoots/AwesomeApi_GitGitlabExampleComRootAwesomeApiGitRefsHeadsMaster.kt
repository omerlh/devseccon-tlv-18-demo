package AwesomeApi.vcsRoots

import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.vcs.GitVcsRoot

object AwesomeApi_GitGitlabExampleComRootAwesomeApiGitRefsHeadsMaster : GitVcsRoot({
    uuid = "20603a8e-aabc-4c16-a294-936ec6ea17b8"
    id = "AwesomeApi_GitGitlabExampleComRootAwesomeApiGitRefsHeadsMaster"
    name = "git@gitlab.example.com:root/awesome-api.git"
    url = "git@gitlab.example.com:root/awesome-api.git"
    authMethod = defaultPrivateKey {
        userName = "git"
    }
})
