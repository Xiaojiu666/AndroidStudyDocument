## 一、 安装

#### 1、下载

#### 2、配置
###### 2.1 配置my.ini
在D:\mysql\mysql-5.6.33-winx64\（注意这个目录要和你自己的目录，我这里下载的是5.6版本，要是你下载的是5.5版本，这个目录是不一样的）目录下新建一个配置文件，文件名叫my.ini，然后把下面的配置代码复制到在my.ini（代码中的路径要改成自己的文件存放路径）
注:不要直接复制之前安装了的mysql的my.ini配置文件，可能很多参数不能识别，所以自手动写)

    代码：

    [mysql]
    # 设置mysql客户端默认字符集
    default-character-set=utf8
    [mysqld]
    #设置3306端口
    port = 3306
    # 设置mysql的安装目录
    basedir=D:\mysql\mysql-5.6.33-winx64
    # 设置mysql数据库的数据的存放目录
    datadir=D:\mysql\mysql-5.6.33-winx64\data
    # 允许最大连接数
    max_connections=200
    # 服务端使用的字符集默认为8比特编码的latin1字符集
    character-set-server=utf8
    # 创建新表时将使用的默认存储引擎
    default-storage-engine=INNODB

###### 2.2 安装mysql服务
命令:mysqld install

###### 2.3 初始化
在MYSQL的安装目录下，手动新建一个data文件夹。
命令:mysqld --initialize

###### 2.3 开启服务
右键我的电脑—>管理—>服务应用程序-->服务—>开启服务

###### 2.4 设置初始密码
    1.在my.ini 中的 [mysqld] 下方加入 skip-grant-tables
    2.重启MYsql
    3.命令:mysql -u root -p 连接数据库服务器命令
    4.遇到Enter  passward:直接回车
    5.https://img-blog.csdn.net/20180702165030415?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2x6Zl9obGg=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70
    6.命令:use mysql      //使用这个数据库
    7.命令:uodate user set passward=passward("123456") whrer user="root";   //修改数据库的密码
    8.命令:flush privileges;      //刷新数据库
    9.删除 skip-grant-tables

###### 2.5 错误
    1862: 使用mysqladmin -uroot -p password //管理员权限运行命令
