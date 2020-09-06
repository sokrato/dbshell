group = "io.github.sokrato"
version = "0.1.0-SNAPSHOT"

plugins {
    application
    kotlin("jvm")
    id("io.freefair.lombok")
    id("com.github.johnrengelman.shadow")
    id("io.github.sokrato.gmate")
}

repositories {
    jcenter()
    mavenCentral()
    mavenLocal()
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation(platform("io.github.sokrato:bom:0.1.0-SNAPSHOT"))

    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))
    testImplementation(kotlin("test"))
    testImplementation(kotlin("test-junit"))

    implementation("org.slf4j:slf4j-api")
    implementation("ch.qos.logback:logback-classic")
}

application {
    mainClassName = "exrepl.ReplKt"
}
