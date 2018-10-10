##RxJava

##1.什么是Rxjava


##2.操作符
####2.1	map(转换)
![](https://upload-images.jianshu.io/upload_images/3994917-002d843b658b98e5.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/620)

	将原有的对象转换为另一种对象
	
####2.2contact(先后顺序,控制被观察者的顺序)
![](https://upload-images.jianshu.io/upload_images/3994917-717b7a5bae136a0e.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/610)
	
	想必在实际应用中，很多时候（对数据操作不敏感时）都需要我们先读取缓存的数据，如果缓存没有数据，再通过网络请求获取，随后在主线程更新我们的UI。


####2.3flatMap


####2.4zip(压合,将多个被观察者的结果压合成一条)


####2.5
