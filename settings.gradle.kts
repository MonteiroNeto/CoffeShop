pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
        //My import to set library github to show itemDetail
        maven{url=uri("https://www.jitpack.io")}
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        //My import to set library github to show itemDetail
        maven{url=uri("https://www.jitpack.io")}
    }
}

rootProject.name = "Coffee Shop"
include(":app")
