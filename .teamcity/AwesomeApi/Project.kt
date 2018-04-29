package AwesomeApi

import AwesomeApi.buildTypes.*
import AwesomeApi.vcsRoots.*
import AwesomeApi.vcsRoots.AwesomeApi_GitGitlabExampleComRootAwesomeApiGitRefsHeadsMaster
import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.Project
import jetbrains.buildServer.configs.kotlin.v2017_2.projectFeatures.VersionedSettings
import jetbrains.buildServer.configs.kotlin.v2017_2.projectFeatures.versionedSettings

object Project : Project({
    uuid = "d4627fee-f848-48a7-b007-76ef8a3a542e"
    id = "AwesomeApi"
    parentId = "_Root"
    name = "Awesome Api"

    vcsRoot(AwesomeApi_GitGitlabExampleComRootAwesomeApiGitRefsHeadsMaster)

    buildType(AwesomeApi_2DynamicSecurityTesting)
    buildType(AwesomeApi_Build)

    features {
        versionedSettings {
            id = "PROJECT_EXT_2"
            mode = VersionedSettings.Mode.ENABLED
            buildSettingsMode = VersionedSettings.BuildSettingsMode.PREFER_SETTINGS_FROM_VCS
            rootExtId = AwesomeApi_GitGitlabExampleComRootAwesomeApiGitRefsHeadsMaster.id
            showChanges = true
            settingsFormat = VersionedSettings.Format.KOTLIN
            storeSecureParamsOutsideOfVcs = true
        }
    }
})
