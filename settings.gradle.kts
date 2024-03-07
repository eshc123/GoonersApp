pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "GoonersApp"
include(":app")
include(":feature:match")
include(":feature:team")
include(":feature:history")
include(":core:data")
include(":core:designsystem")
include(":core:network")
include(":feature:playground")
include(":feature:home")
include(":core:database")
include(":core:domain")
include(":feature:chat")
include(":core:common")
include(":feature:login")
