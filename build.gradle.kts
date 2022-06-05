plugins {
    id("java")
    id("application")
    id("idea")
    id("org.springframework.boot") version "2.6.7"
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
}

var shufflerLibVersion = "1.0.1"
var springBootVersion = "2.6.7"
var lombokBootVersion = "1.18.24"
val codeGsonVersion = "2.9.0"
var junitVersion = "5.8.2"
var mockitoVersion = "4.5.1"

dependencies {
    implementation("ru.acuma:shuffler-lib:$shufflerLibVersion")

    implementation("org.springframework.boot:spring-boot-starter:$springBootVersion")
    implementation("org.springframework.boot:spring-boot-starter-web:$springBootVersion")

    compileOnly("org.projectlombok:lombok:$lombokBootVersion")
    annotationProcessor("org.projectlombok:lombok:$lombokBootVersion")

    testCompileOnly("org.projectlombok:lombok:$lombokBootVersion")
    testAnnotationProcessor("org.projectlombok:lombok:$lombokBootVersion")
    testImplementation("org.springframework.boot:spring-boot-starter-test:$springBootVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
    testImplementation("org.mockito:mockito-core:$mockitoVersion")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
