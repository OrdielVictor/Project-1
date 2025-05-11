
plugins {
    alias(libs.plugins.android.application)
    
}

android {
    namespace = "com.example.project1"
    compileSdk = 34
    buildToolsVersion = "34.0.4"
    
    defaultConfig {
        applicationId = namespace
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        
        vectorDrawables.useSupportLibrary = true
    }
    
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    buildFeatures {
        viewBinding = true
        
    }
    
}

dependencies {
    
    implementation(libs.bundles.androidx)
    implementation(libs.google.material)
}
