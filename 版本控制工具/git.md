##1.下载使用

##2.Github结合
	1.上传
		1. 登陆github创建一个Repository，复制仓库地址
		2. echo "# Test" >> README.md  //创建一个名为Readme.md的文档，内容是# Test
		3. git init						//建立并初始化Git仓库
		4. git add .					//将项目的所有文件添加到仓库中
		5. git commit -m "注释语句"		//提交到仓库
		6. git remote add origin https: //将本地的仓库关联到GitHub  remote(远程)  origin(源头)
		7. git pull origin master		//上传github之前pull一下
		8. git push -u origin master		//上传代码到GitHub远程仓库
	
	2.更新上传
		1. git status					//查看代码状态
		2. git add *					//更新所有代码
		3. git commit -m "更新说明"		//提交并加说明
		4. git pull						//先git pull,拉取当前分支最新代码
		5. git push origin master		//push到远程master分支上