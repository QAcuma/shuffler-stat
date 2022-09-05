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
    implementation("ru.acuma:shuffler-lib:1.0.8")
    implementation(libs.spring.starter)
    implementation(libs.spring.web)
    implementation(libs.spring.security)
    implementation(libs.bundles.telegram)
    implementation(libs.bundles.data)
    implementation(libs.jooq)
    implementation(libs.bundles.util)

    compileOnly(libs.lombok)
    annotationProcessor(libs.lombok)

    testCompileOnly(libs.lombok)
    testAnnotationProcessor(libs.lombok)
    testImplementation(libs.bundles.test)

    implementation("org.springframework.boot:spring-boot-starter-security:$springBootVersion")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
