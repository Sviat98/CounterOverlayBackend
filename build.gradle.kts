
plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.ktor)
    alias(libs.plugins.kotlin.plugin.serialization)
}

group = "com.bashkevich.counteroverlaybackend"
version = "0.0.1"

application {
    mainClass = "io.ktor.server.netty.EngineMain"

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

ktor{
    @OptIn(io.ktor.plugin.OpenApiPreview::class)
    openApi {
        title = "OpenAPI example"
        version = "2.1"
        summary = "This is a sample API"
        // Location of the generated specification (defaults to openapi/generated.json)
        target = project.layout.buildDirectory.file("openapi/documentation.json")
    }
}

// Builds OpenAPI specification automatically
tasks.processResources {
    dependsOn("buildOpenApi")
}

dependencies {
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.websockets)
    implementation(libs.koin.ktor)
    implementation(libs.koin.logger.slf4j)
    implementation(libs.ktor.serialization.kotlinx.json)
    implementation(libs.ktor.server.content.negotiation)
    implementation(libs.ktor.server.status.pages)

    implementation(libs.postgresql)
    implementation(libs.exposed.core)
    implementation(libs.exposed.jdbc)
    implementation(libs.exposed.dao)

    implementation(libs.ktor.server.call.logging)
    implementation(libs.ktor.server.cors)
    implementation(libs.ktor.server.openapi)
    implementation(libs.ktor.server.swagger)
    implementation(libs.ktor.server.netty)
    implementation(libs.logback.classic)
    implementation(libs.ktor.server.config.yaml)
    testImplementation(libs.ktor.server.test.host)
    testImplementation(libs.kotlin.test.junit)
}


ktor {
    fatJar {
        archiveFileName.set("counteroverlaybackend.jar")
    }

    docker {
        jreVersion.set(JavaVersion.VERSION_17)
        localImageName.set("sample-docker-image")
        imageTag.set("0.0.1-preview")
        portMappings.set(
            listOf(
                io.ktor.plugin.features.DockerPortMapping(
                    80,
                    8080,
                    io.ktor.plugin.features.DockerPortMappingProtocol.TCP
                )
            )
        )
    }
}
