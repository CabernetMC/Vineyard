import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    java
    `maven-publish`
    id("io.github.goooler.shadow")
}

tasks.jar {
    enabled = false
}

tasks.compileJava {
    options.encoding = "UTF-8"
    sourceCompatibility = "21"
    targetCompatibility = "21"
}

tasks.withType<ShadowJar> {
    archiveClassifier = ""
    archiveVersion = ""
}

tasks.build {
    dependsOn(tasks.withType<ShadowJar>())
}

publishing {
    publications {
        create<MavenPublication>("Maven") {
            shadow.component(this)
            this.groupId = "io.github.cabernetmc"
            this.version = rootProject.version.toString()
        }
    }

    repositories {
        maven("https://maven.miles.sh/snapshots") {
            credentials {
                this.username = System.getenv("CABERNETMC_REPOSILITE_USERNAME")
                this.password = System.getenv("CABERNETMC_REPOSILITE_PASSWORD")
            }
        }
    }
}
