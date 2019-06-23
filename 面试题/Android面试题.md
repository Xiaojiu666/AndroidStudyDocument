
## 常见问题
####	1.JVM和DVM的区别
	1.	JVM，
		1.	JVM基于栈，栈是内存上面的一段连续的存储空间
		2.	JVM是Oracle公司
		3.	java文件 -> .class文件 -> .jar文件
		4.	![avatar](https://img-blog.csdn.net/20161104122858683?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center)
	2.
		1.	DVM，Dalvik Virtual Machine  Dalvik基于寄存器 Dalvik经过优化，允许在有限的内存中同时运行多个虚拟机的实例，并且每一个 Dalvik应用作为一个独立的Linux进程执行。独立的进程可以防止在虚拟机崩溃的时候所有程序都被关闭。寄存器是CPU上面的一块存储空间
		2.	Google
		3.	java文件 –> .class文件 -> .dex文件


####	2.说说你对AIDL的理解，原理及其步骤(百度)
		AIDL介绍:AIDL,安卓端跨进程通信，
		AIDL，全称是Android Interface Define Language，即安卓接口定义语言，可以实现安卓设备中进程之间的通信（Inter Process Communication, IPC）。假设有如下场景，需要计算a+b的值，在客户端中获取a和b的值，然后传递给服务端，服务端进行a+b的计算，并将计算结果返回给客户端。
		这里的客户端和服务端均是指安卓设备中的应用，由于每一个应用对应一个进程，由此可以模拟安卓系统中通过AIDL进行进程之间的通信。
		AIDL的具体使用步骤如下：


####	3.如果对图片进行采样压缩，假设图片是TEST.JPG,请写出简要原理(百度)
	https://blog.csdn.net/bluezhangfun/article/details/50402639
	1.设置bitmapFactory.options中的 inJustDecodeBunlde 对第一次采样进行配置， ture 只读文件的宽高，不读大小进内存
	2.通过bitmapFactory.decodeFile进行对图片的获取，
	3.进行采样率计算
	3.1 根据屏幕的宽高，根据通过options获取的图片宽高，进行计算
	3.2 如果图片宽高的1/2 / 采样率 还是大于屏幕的宽高，通过while循环继续循环增加采样率，直到图片宽高小于屏幕的宽和高，inSampleSize*=2 每次翻两倍
	4.通过计算出的采样率，设置给options.insmple()
	5.设置每一个像素点的存储方式 inPreferredConfig =Bitmap.Config.RGB565
####	4.Touch事件分发机制(百度)

####	5.ListView和RecyclerView的使用，区别？

####	6.Git问题
######	6.1新建一个分支
	git branch text
######	6.2提交修改内容
	git add ”“
	git commit
######	6.3把test分支合并到develop
	git merge develop
######	6.4把develop推送到远程服务器
	git remote add origin ”地址“
######	6.5更新develop分支
	git checkout develop

######	7.内存泄露问题
	内存指程序在申请内存后,无法释放已经申请的内存空间,一次内存泄露危害可以忽略,但内存泄露堆积后的结果很严重,无论多少内存,迟早会被占光
- 1.单例模式导致的内存泄漏

		最常见的例子就是创建这个单例对象需要传入一个Context，这时候传入了一个Activity类型的Context，由于单例对象的静态属性，
		导致它的生命周期是从单例类加载到应用程序结束为止，所以即使已经finish掉了传入的Activity，由于我们的单例对象依然持
		有Activity的引用，所以导致了内存泄漏。解决办法也很简单，不要使用Activity类型的Context，使用Application类型的Context可以避免内存泄漏。



- 2.静态变量导致的内存泄漏

		静态变量是放在方法区中的，它的生命周期是从类加载到程序结束，可以看到静态变量生命周期是非常久的。
		最常见的因静态变量导致内存泄漏的例子是我们在Activity中创建了一个静态变量，而这个静态变量的创建需要传入Activity
		的引用this。在这种情况下即使Activity调用了finish也会导致内存泄漏。原因就是因为这个静态变量的生命周期几乎和整个应
		用程序的生命周期一致，它一直持有Activity的引用，从而导致了内存泄漏。

- 3.非静态内部类导致的内存泄漏

		非静态内部类导致内存泄漏的原因是非静态内部类持有外部类的引用，最常见的例子就是在Activity中使用Handler和Thread了。使用非静态内部类创建的Handler和Thread在执行延时操作的时候会一直持有当前Activity的引用，如果在执行延时操作的时候就结束Activity，这样就会导致内存泄漏。解决办法有两种：第一种是使用静态内部类，在静态内部类中使用弱引用调用Activity。第二种方法是在Activity的onDestroy中调用handler.removeCallbacksAndMessages来取消延时事件。

- 4.使用资源未及时关闭导致的内存泄漏

		使用资源未及时关闭导致的内存泄漏。常见的例子有：操作各种数据流未及时关闭，操作Bitmap未及时recycle等等。
		有的三方库提供了注册和解绑的功能，最常见的就是EventBus了，我们都知道使用EventBus要在onCreate中注册，在onDestroy中解绑。如果没有解绑的话，EventBus其实是一个单例模式，他会一直持有Activity的引用，导致内存泄漏。同样常见的还有RxJava，在使用Timer操作符做了一些延时操作后也要注意在onDestroy方法中调用disposable.dispose()来取消操作。

- 5.属性动画导致的内存泄漏

		常见的例子就是在属性动画执行的过程中退出了Activity，这时View对象依然持有Activity的引用从而导致了内存泄漏。
		解决办法就是在onDestroy中调用动画的cancel方法取消属性动画。

- 6.WebView导致的内存泄漏

		WebView比较特殊，即使是调用了它的destroy方法，依然会导致内存泄漏。其实避免WebView导致内存泄漏的最好方法就是
		让WebView所在的Activity处于另一个进程中，当这个Activity结束时杀死当前WebView所处的进程即可，我记得阿里钉钉的WebView就是另外开启的一个进程，应该也是采用这种方法避免内存泄漏。


##	UI方面
####	1.View
######	1.1 触摸事件事件分发机制

![avatar](image\dispath.png)

	一、为什么要有事件分发机制
		为了解决安卓触摸事件需要在哪层响应，让事件可控
		响应层分为三层Activity-->ViewGroup-->View
	二、默认原理
		dispatchTouch(控制事件和分发事件)
		onTouch(响应事件和处理事件)
		在上面两个方法没有进行任何方法重写和控制情况下，也就是默认的所有dispatchTouch 和 OnTouch返回值为super的情况下，事件会默认的走完三个层级，并且三个层级全部进行事件的响应
	三、自定义需求
		1.1 三层全部不响应，那么无论dispatchTouch返回true&false 他自己和下面两层的onToutch都不会响应。
		1.2 AC层响应，下面两层不响应，将VG层的dispatchTouch返回false，因为在AC层dispatchTouch的源码中，如果返回值为false
	四、总结
		只要控制好dispatchTouch方法，就可以控制事件响应的对应的层级关系，onInterceptTouch方法主要作用是担心ViewGroup里面没有子View，但是AC就不需要担心里面没有子ViewGroup ，因为AC里面必然有xml否则会报错

######	1.2 自定义View
######	1.3 View的绘制流程
#### 2.RecyclerView
######

## 五大组件
#### 1.activity
	Activity是Android程序与用户交互的窗口，是Android构造中最基本的一种，它需要为保持各界面的状态，
	做很多持久化的事情，妥善管理生命周期以及一些跳转逻辑。
###### 1.1 activity生命周期
###### 1.2 activity启动模式
###### 1.3 activity进行数据保存和恢复
	开发者提前可以复写onSaveInstanceState方法，创建一个Bundle类型的参数，
	把数据存储在这个Bundle对象中，这样即使Activity意外退出
	，Activity被系统摧毁，当重新启动这个Activity而调用onCreate方法时，上述Bundle对象会作为参数传递给onCreate方法，开发者可以从Bundle对象中取出保存的数据，利用这些数据将Activity恢复到被摧毁之前的状态。


#### 2.fragment
###### 2.1 fragment生命周期
###### 2.1 fragment生命周期
######

#### 3.service
######	3.1Service的两种使用方式分别是什么？它们的生命周期分别怎样迁移？
######	3.2什么是AIDL？AIDL的作用是什么？它的基本使用流程是怎么样的？

#### 4.BroadcastReceiver
######	4.1什么是BroadcastReceiver？它有什么作用？
######	4.2什么是有序广播？有序广播有什么特点？什么是系统广播？
######	4.3什么是粘性广播？它跟普通广播有什么区别？

#### 5.ContentProvider
######	5.1什么是ContentProvider？如何自定义一个ContentProvider？
######	5.2你使用过哪些系统的ContentProvider？
######	5.3什么是粘性广播？它跟普通广播有什么区别？



#### 6.Intent
######	6.1 Intent是什么？有什么用处？
######	6.2	Intent如何传值？Bundle是什么，有什么用？
######	6.3 序列化的两种方式？区别


## 数据&&网络
####	1.数据
######	1.1数据常用的数据持久化(长久保存数据)方式有哪些？


####	2.网络
######	2.1TCP和UDP的区别是什么？
######	2.2Http的get和post方法的区别什么？


## 线程&&进程方面
####	1.线程
###### 1.Handler消息机制
		1、主线程
		2、子线程
		3、Message
		4、MessageQueen
		5、Handler
		6、Looper
###### 2.Binder机制

####	2.异步
###### 2.1 常见的实现异步的方式有哪些？

## 性能优化
####	1.图片
###### 1.1	图片压缩
###### 1.2	图片压缩

####	2.网络
###### 2.1	ListView条目复用


##	框架问题


https://www.cnblogs.com/ldq2016/p/9035666.html
