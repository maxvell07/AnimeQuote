plugins {
    alias(libs.plugins.jetbrains.kotlin.jvm)
}

kotlin {
    compilerOptions {
        jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_21
    }
}
dependencies {
    implementation(project(":domain"))
    api(libs.javax.inject)
    api(libs.retrofit)
    api(libs.converter.gson)
}
