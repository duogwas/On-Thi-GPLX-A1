plugins {
    id 'com.android.application'
    id 'com.huawei.agconnect'
}

android {
    compileSdk 31

    defaultConfig {
        applicationId "hou.duogwas.onthigplxa1"
        minSdk 28
        targetSdk 31
        versionCode 1
        versionName "1.0"

        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        debug {
            packagingOptions {
                // If the CPU architecture is ARMv7 or ARMv8, add the following configuration:
                doNotStrip "*/arm64-v8a/libucs-credential.so"
                doNotStrip "*/armeabi-v7a/libucs-credential.so"
                // If the CPU architecture is x86, add the following configuration:
                doNotStrip "*/x86/libucs-credential.so"
                doNotStrip "*/x86_64/libucs-credential.so"
            }
        }
        release {
            packagingOptions {
                // If the CPU architecture is ARMv7 or ARMv8, add the following configuration:
                doNotStrip "*/arm64-v8a/libucs-credential.so"
                doNotStrip "*/armeabi-v7a/libucs-credential.so"
                // If the CPU architecture is x86, add the following configuration:
                doNotStrip "*/x86/libucs-credential.so"
                doNotStrip "*/x86_64/libucs-credential.so"
            }
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_11
        targetCompatibility JavaVersion.VERSION_11
    }
}

dependencies {
    implementation 'androidx.appcompat:appcompat:1.3.1'
    implementation 'com.google.android.material:material:1.4.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.1'
    implementation 'androidx.navigation:navigation-fragment:2.3.5'
    implementation 'androidx.navigation:navigation-ui:2.3.5'
    testImplementation 'junit:junit:4.+'
    androidTestImplementation 'androidx.test.ext:junit:1.1.3'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'
    //card view
    implementation "androidx.cardview:cardview:1.0.0"
    //toolbar,navigation view
    implementation 'com.google.android.material:material:1.1.0'
    //hmscore
    implementation 'com.huawei.agconnect:agconnect-core:1.6.0.300'
    implementation 'com.huawei.hms:hwid:6.1.0.302'
    implementation 'com.huawei.hms:ads:3.4.48.301'
}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       