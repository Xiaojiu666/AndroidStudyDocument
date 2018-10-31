##一、NDK配置
1.	通过AndroidStudio File--Setting--SDK-- NDK(Install) 
2.	在local.properties中配置ndk.dir=D:\guanmanman\androidStudio\sdk\ndk-bundle
		![](https://images2015.cnblogs.com/blog/955290/201704/955290-20170426163012397-1396228630.png)
3.	在工程中gradle.properties中添加对旧版本的NDK支持的配置 android.useDeprecatedNdk=true
		![](https://images2015.cnblogs.com/blog/955290/201704/955290-20170426163021303-615450010.png)

##二、问题

-	1.Error Gradle sync failed: Failed to find CMake
-	解决办法：
	-	通过AndroidStudio File--Setting--SDK  找到sdktools中的 CMake

-	2.sdktools中没有CMake
-	解决办法：
	-	找到AndroidStudio的安装目录，右键打开后缀为64的AS