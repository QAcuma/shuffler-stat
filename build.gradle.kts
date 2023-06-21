plugins {
    id("java")
    id("application")
    id("idea")
    id("org.springframework.boot") version "2.7.3"
}

group = "ru.acuma"
version = "1.0.0"

java {
    sourceCompatibility = JavaVersion.VERSION_13
    targetCompatibility = JavaVersion.VERSION_13
}

repositories {
    mavenLocal()
    mavenCentral()
    maven("https://jitpack.io")
}

var springBootVersion = "2.7.3"

dependencies {
    implementation("ru.acuma:shuffler-lib:2.0.0")
    implementation(libs.spring.starter)
    implementation(libs.spring.web)
    implementation(libs.spring.security)
    implementation(libs.bundles.telegram)
    implementation(libs.bundles.data)
    implementation(libs.jooq)
    implementation(libs.bundles.util)

    compileOnly(libs.lombok)
    annotationProcessor(libs.lombok)

    implementation("org.springframework.boot:spring-boot-starter-security:$springBootVersion")
}

application {
    applicationDefaultJvmArgs = listOf(
            "--add-opens=java.base/java.lang=ALL-UNNAMED",
            "--add-opens=java.base/java.lang.reflect=ALL-UNNAMED"
    )
}

tasks.withType<Test> {
    useJUnitPlatform()
}
