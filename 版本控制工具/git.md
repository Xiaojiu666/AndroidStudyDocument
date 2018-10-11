##1.下载使用
-	1.账号密码本地配置

		 我的电脑 - 属性 - 高级系统设置 - 环境变量 - 新建变量变量名HOME，变量值%USERPROFILE%

	![](http://www.runoob.com/wp-content/uploads/2015/03/271117384245853.png)
-	2.创建账号密码文件

		 开始 - 运行 中打开%Home%，即windows的管理员账号文件夹。新建一个名为"_netrc"的文件，填写你要保存的服务器地址及账号密码，保存。 

![](http://www.runoob.com/wp-content/uploads/2015/03/271123307214691.png)
![](http://www.runoob.com/wp-content/uploads/2015/03/271123401437312.png)

##2.Github命令
	1. 上传
		1. 登陆github创建一个Repository，复制仓库地址
		2. echo "# Test" >> README.md  //创建一个名为Readme.md的文档，内容是# Test
		3. git init						//建立并初始化Git仓库
		4. git add .					//将项目的所有文件添加到仓库中
		5. git commit -m "注释语句"		//提交到仓库
		6. git remote add origin https: //将本地的仓库关联到GitHub  remote(远程)  origin(源头)
		7. git pull origin master		//上传github之前pull一下
		8. git push -u origin master		//上传代码到GitHub远程仓库
	
	2. 更新上传
		1. git status					//查看代码状态
		2. git add *					//更新所有代码
		3. git commit -m "更新说明"		//提交并加说明
		4. git pull						//先git pull,拉取当前分支最新代码
		5. git push origin master		//push到远程master分支上



##3.GitGUI
	
-	1.克隆已有项目


	
-	2.检出项目
-
		1.先来设置与远程地址的关联，Git remote：
![](http://www.runoob.com/wp-content/uploads/2015/03/271242561118002.png)
![](http://www.runoob.com/wp-content/uploads/2015/03/271244220336453.png)

		 填写SSH地址与项目名。下面有3个选项：
		第一个：立刻获取最新改动（所以如果是本地克隆远程一个项目，也可以这样操作）。
		第二个：本地新建的项目，初始化远程仓库并发布过去。
		第三个：什么也不做。 
		2.在项目的进行过程中，获取仓库的最新改动Git fetch
![](http://www.runoob.com/wp-content/uploads/2015/03/271259025495085.png)
![](http://www.runoob.com/wp-content/uploads/2015/03/271300329558531.png)
		
		3.合并
		请注意啦，不管你本地有没有代码，fetch之后呢，是都要merge的，
		也就是说，fetch下来后，大大的代码还在一个小黑屋里，我们需要把它装到自己兜里。
		选择合并 - 本地合并，然后选择本地的分支（如果你没有创建分支，则只有1个主支master） 
![](http://www.runoob.com/wp-content/uploads/2015/03/271254126278757.png)

		4.冲突处理（Conflict） 
		 合并的过程中可能会出现一些红色的文件与一堆叹号，这时候慌慌张张的点啥它都不管用，不用担心，不是程序坏了，
		只是有冲突的文件，例如A童鞋写了width:1180px，你写了width:auto。那到底用你们谁的呢。
		在GUI界面正文区，正文区右键可以选择，Use local version（使用本地版本）或Use remote version（使用远程版本），
		到底用你的还是小伙伴的？或者你也可以自己再整合。 
![](http://www.runoob.com/wp-content/uploads/2015/03/271257485644055.png)



##4.参考资料
-	1.https://www.runoob.com/w3cnote/git-gui-window.html//