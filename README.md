# GeneralNetwork

通用网络

## gradle使用：

一、Project下的build.gradle文件下添加

allprojects {
    repositories {
      ...
      maven { url 'https://jitpack.io' }
    }
}

二、Module下的build.gradle文件下添加

1.0.5之前

dependencies {
    
    implementation 'com.github.Lvluffy:GeneralNetwork:1.0.5'
          
}

1.0.6之后

dependencies {
    
    implementation 'com.github.Lvluffy.GeneralNetwork:apilib:1.0.6'
    
    implementation 'com.github.Lvluffy.GeneralNetwork:mvplib:1.0.6'
          
}
