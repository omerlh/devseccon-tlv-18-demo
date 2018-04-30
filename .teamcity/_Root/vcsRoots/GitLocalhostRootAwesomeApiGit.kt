package _Root.vcsRoots

import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.vcs.GitVcsRoot

object GitLocalhostRootAwesomeApiGit : GitVcsRoot({
    uuid = "50db1273-4a34-4a6f-9c7c-2eae3288d7c7"
    id = "GitLocalhostRootAwesomeApiGit"
    name = "git@localhost:root/awesome-api.git"
    url = "git@localhost:root/awesome-api.git"
    authMethod = defaultPrivateKey {
        userName = "git"
    }
})
