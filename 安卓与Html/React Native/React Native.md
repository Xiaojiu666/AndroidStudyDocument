1.http://blog.csdn.net/sinat_34380438/article/details/77648476?locationNum=9&fps=1
2.http://blog.csdn.net/mymy_blog/article/details/73277884

##	一、React Native介绍
		是Facebook开源的跨平台移动应用开发框架，使用Javascript语言

-	Native App 属于本地开发，主要使用语言Java、Objective-C
		-	优点:
			-	1、相比于其它模式，提供最佳的用户体验，最优质的用户界面，最华丽的交互
			-	2、针对不同平台提供不同体验
			-	3、可节省带宽成本，打开速度更快
			-	4、功能最为强大,特别是在与系统交互中,几乎所有功能都能实现
		-	缺点:
			-	1.无法跨平台
			-	2.项目开发成本高，（Android+IOS开发人员）
-	WebApp（H5+C3）
		-	优点：
			-	1、可以跨平台，调试方便
			-	2、无需安装，不会占用手机内存，而且更新速度最快
			-	3.不存在多版本问题，维护成本低
			-	4.临时入口，可以随意嵌入
		-	缺点：
			-	1、依赖于网络，第一次访问页面速度慢，耗费流量
			-	2、受限于手机和浏览器性能，用户体验相较于其他模式最差
			-	3、功能受限，大量移动端功能无法实现

-	Hybird(本地+HTML混合开发，由原生提供统一的API给JS调用，实际的主要逻辑有Html和JS来完成，最终是放在webview中显示的，所以只需要写一套代码即可达到跨平台效果，另外也可以直接在浏览器中调试，很方便。最重要的是只需要一个前端人员稍微学习下JS api的调用即可)
		-	优点：
			-	结合上面的两个优点，
		-	缺点：
			-	成本高
-	Fullter
		-	学习地址
			-	https://flutterchina.club/


##		二、React Native的环境安装
####	React Native

		使用git 工具去svn上下载ReacNative环境 git clone https://github.com/facebook/react-native.git

####	Node

		Node.js 是一个基于 Chrome V8 引擎的 JavaScript 运行环境。 Node.js 使用了一个事件驱动、非阻塞式 I/O 的模型。 [1]
		Node 是一个让 JavaScript 运行在服务端的开发平台，它让 JavaScript 成为与PHP、Python、Perl、Ruby 等服务端语言平起平坐的脚本语言。

-	下载地址，https://nodejs.org/en/   NPM是随同NodeJS一起安装的包管理工具，能解决NodeJS代码部署上的很多问题，类似于安卓的Gradle
-	工具库
	-	node -v		//node环境
	-	npm install -g react-native-cli //React Native的命令行工具用于执行创建、初始化、更新项目、运行打包服务（packager）等任务。
	-
	-	react-native init AwesomeProject
	-	react-native run-android
####	AndroidStudio 配置

	-	 SDK Platforms：选择Show Package Details，然后在Android 6.0 (Marshmallow)中勾选Google APIs、Intel x86 Atom System Image、Intel x86 Atom_64 System Image以及Google APIs Intel x86 Atom_64 System Image

	-	 SDK Tools窗口中，选择Show Package Details，然后在Android SDK Build Tools中勾选Android SDK Build-Tools 23.0.1


	-	ANDROID_HOME系统变量: 路径就是SDK位置
	-	给SDK Tools和 Platforms Tools 配置 PATH 环境变量

####	安装步骤
配置node的国内镜像

	npm config set registry https://registry.npm.taobao.org --global
	npm config set disturl https://npm.taobao.org/dist --global

Yarn是 Facebook 提供的替代 npm 的工具，可以加速 node 模块的下载。React Native 的命令行工具用于执行创建、初始化、更新项目、运行打包服务（packager）等任务。

	npm install -g yarn react-native-cli

安装完 yarn 后同理也要设置镜像源：

	yarn config set registry https://registry.npm.taobao.org --global
	yarn config set disturl https://npm.taobao.org/dist --global


####	创建一个项目(两种创建方式的包 是不同的)
-	方式一：（官方推荐，但需要下载APP Expo扫描，总会报错，具体原因没查到）

		create-react-native-app AwesomeProject
		cd AwesomeProject
		npm start

-	方式二：(简单 会自动生成安卓项目文件，可以直接在Studio上运行)

		react-native init AwesomeProject
		cd AwesomeProject
		react-native run-android
		npm uninstall react-native
		npm install --save react-native@0.55.4
		react-native run-android
		npm install --save babel-core@latest babel-loader@latest
		npm uninstall --save babel-preset-react-native
		npm install --save babel-preset-react-native@4.0.0
		react-native run-android


## 示例--HelloWorld
	import React, { Component } from 'react';
		import { Text, View } from 'react-native';

			export default class HelloWorldApp extends Component {
			render() {
			return (
					<View style={{ flex: 1, justifyContent: "center", alignItems: "center" }}>
						<Text>Hello, world!</Text>
					</View>
			);
		}
	}


## 语法
####	let 和 const 命令
let

		let ES6 新增了let命令，用来声明变量。它的用法类似于var，但是所声明的变量，只在let命令所在的代码块内有效。

const

	const声明一个只读的常量。一旦声明，常量的值就不能改变。
## 语法--样式



##	错误

#######如果以上两种方式混用，可能会导致Cannot find entry file index.android.js
#######unable to load script from assets ‘index.android bundle’ ,make sure your bundle is packaged correctly or youu’re runing a packager server
#######解决:创建一个assets文件 在项目的跟目录下执行  react-native bundle --platform android --dev false --entry-file index.js --bundle-output android/app/src/main/assets/index.android.bundle --assets-dest android/app/src/main/res/
#######原因：


##	文章
-	https://www.cnblogs.com/CyLee/p/9912977.html			//ReactNative 环境的搭建和启动（安卓版）
