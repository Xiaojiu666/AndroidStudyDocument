## 版本控制工具介绍

###### 本地版本控制
  许多人习惯用复制整个项目目录的方式来保存不同的版本，或许还会改名加上备份时间以示区别。这么做唯一的好处就是简单。不过坏处也不少：有时候会混淆所在的工作目录，一旦弄错文件丢了数据就没法撤销恢复。

  为了解决这个问题，人们很久以前就开发了许多种本地版本控制系统，大多都是采用某种简单的数据库来记录文件的历次更新差异

###### 集中化的版本控制系统
  接下来人们又遇到一个问题，如何让在不同系统上的开发者协同工作？于是，集中化的版本控制系统（ Centralized Version Control Systems，简称 CVCS ）应运而生。这类系统，诸如 CVS，Subversion 以及 Perforce 等，都有一个单一的集中管理的服务器，保存所有文件的修订版本，而协同工作的人们都通过客户端连到这台服务器，取出最新的文件或者提交更新。多年以来，这已成为版本控制系统的标准做法

  优点：每个人都可以在一定程度上看到项目中的其他人正在做些什么。而管理员也可以轻松掌控每个开发者的权限，并且管理一个 CVCS 要远比在各个客户端上维护本地数据库来得轻松容易。

  缺点：要是中央服务器的磁盘发生故障，碰巧没做备份，或者备份不够及时，就会有丢失数据的风险。最坏的情况是彻底丢失整个项目的所有历史更改记录，而被客户端偶然提取出来的保存在本地的某些快照数据就成了恢复数据的希望。但这样的话依然是个问题，你不能保证所有的数据都已经有人事先完整提取出来过。本地版本控制系统也存在类似问题，只要整个项目的历史记录被保存在单一位置，就有丢失所有历史更新记录的风险。

###### 分布式版本控制系统
  分布式版本控制系统（ Distributed Version Control System，简称 DVCS ）

  在这类系统中，像 Git，Mercurial，Bazaar 以及 Darcs 等，客户端并不只提取最新版本的文件快照，而是把代码仓库完整地镜像下来。这么一来，任何一处协同工作用的服务器发生故障，事后都可以用任何一个镜像出来的本地仓库恢复。因为每一次的提取操作，实际上都是一次对代码仓库的完整备份

## Git的安装

## Git基础
###### 工作区、暂存区和版本库
![](http://www.runoob.com/wp-content/uploads/2015/02/1352126739_7909.jpg)

- 工作区:在电脑里能看到的目录。

- 暂存区:英文叫stage, 或index。一般存放在 ".git目录下" 下的index文件（.git/index）中，所以我们把暂存区有时也叫作索引（index）

- 版本库:工作区有一个隐藏目录.git，这个不算工作区，而是Git的版本库。



## Git常用命令分类
###### 初始化项目
- git init        //将文件夹初始化为git本地仓库
- git add         
- git add README
- git commit -m 'initial project version'
- git checkout -- <文件路径>

###### 提交
- git add -A  提交所有变化
- git add -u  提交被修改(modified)和被删除(deleted)文件，不包括新文件(new)
- git add .  提交新文件(new)和被修改(modified)文件，不包括被删除(deleted)文件

###### 对暂存区操作
- git add  
- git rm  //移除

###### 版本控制
- git log  //历史版本查看
- git log -p -2   //最近两个历史版本对比

###### 远程仓库
- git clone [url]    //检出指定Url上的仓库内容
- git remote         //
- git remote -v      //查看当前本地文件的远程仓库信息
- git remote add [shortname] [url] //将本地仓库与远程仓库管理
- git remote show [shortname]   //查看某个远程仓库的详细信息
- git pull       //抓取数据合并到本地
- git remote rename [old name] [new name]  //重命名
- git remote rm [shortname]   //移除远程远程仓库关联

###### 打标签
- git tag
- git tag -l 'v1.4.2.※'             // 模糊搜索
- git tag -a [tag name] -m '备注'  //新建
- git show [tag name]   //查看相应标签的版本信息
- git tag -a v1.2 9fceb02 //对早先的某次提交加注标签


## Git几种事件命令操作步骤

###### 本地提交到版本库
- git add .      //添加目录下所有文件到暂存区
- git commit -m 'initial project version' //提交到版本库


######


######  版本库提交到远程仓库

###### 本地修改文件后
- 如果需要提交到版本库 ，重复<本地提交到版本库>
- 使用 git checkout -- <文件路径>  // git checkout .检出所有

######  远程仓库更新代码
- $ git remote -v  查看远程仓库信息 会显示出该本地库关联几个远程仓库
- $ git fetch [name] master   从仓库检出分支
- $ git merge origin/master   合并本地仓库和远程仓库
-
