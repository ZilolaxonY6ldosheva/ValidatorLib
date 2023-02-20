# README

>Getting Started
### 1. Gradle Dependency
* Add the `JitPack` repository to your project's build.gradle file

- For Gradle version 5.x.x or less
```

allprojects {
    repositories {
    ...
    maven { url 'https://jitpack.io' }
    }
}
```
- For Gradle version 6.x.x and above, in settings.gradle file inside `pluginManagement` block
```
      pluginManagement {
        repositories {
        ...
        maven { url 'https://jitpack.io' }
        }
    }
```
* Add the dependency in your app's build.gradle file

```
dependencies {
	implementation 'com.github.ZilolaxonY6ldosheva:ValidatorLib:1.0.2'
}
