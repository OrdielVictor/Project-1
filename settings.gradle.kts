pluginManagement {
  repositories {
    maven {
        setUrl("https://maven.aliyun.com/repository/public")
    }
    gradlePluginPortal()
    google()
    mavenCentral()
  }
}

dependencyResolutionManagement {
  repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
  repositories {
    maven {
        setUrl("https://maven.aliyun.com/repository/public")
    }
    google()
    mavenCentral()
  }
}

rootProject.name = "Project #1"

include(":app")