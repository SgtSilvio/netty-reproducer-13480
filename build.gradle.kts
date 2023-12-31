plugins {
    java
}

version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.netty:netty-resolver-dns-native-macos:4.1.95.Final")
    implementation("io.netty:netty-resolver-dns-native-macos:4.1.95.Final:osx-aarch_64")
//    implementation(files("/Users/sgiebl/Projects/sgtsilvio/netty/resolver-dns-native-macos/target/netty-resolver-dns-native-macos-4.1.95.Final-SNAPSHOT-osx-aarch_64.jar"))
    implementation("io.netty:netty-resolver-dns-native-macos:4.1.95.Final:osx-x86_64")
}
