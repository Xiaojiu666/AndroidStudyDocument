#1.JVM和DVM的区别
	1.	JVM，
		1.	JVM基于栈，栈是内存上面的一段连续的存储空间
		2.	JVM是Oracle公司
		3.	java文件 -> .class文件 -> .jar文件
		4.	![avatar](https://img-blog.csdn.net/20161104122858683?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center)
	2.	
		1.	DVM，Dalvik Virtual Machine  Dalvik基于寄存器 Dalvik经过优化，允许在有限的内存中同时运行多个虚拟机的实例，并且每一个 Dalvik应用作为一个独立的Linux进程执行。独立的进程可以防止在虚拟机崩溃的时候所有程序都被关闭。寄存器是CPU上面的一块存储空间
		2.	Google
		3.	java文件 –> .class文件 -> .dex文件


#2.说说你对AIDL的理解，原理及其步骤(百度)
###1.AIDL介绍:AIDL,安卓端跨进程通信，
	AIDL，全称是Android Interface Define Language，即安卓接口定义语言，可以实现安卓设备中进程之间的通信（Inter Process Communication, IPC）。
	假设有如下场景，需要计算a+b的值，在客户端中获取a和b的值，然后传递给服务端，服务端进行a+b的计算，并将计算结果返回给客户端。
	这里的客户端和服务端均是指安卓设备中的应用，由于每一个应用对应一个进程，由此可以模拟安卓系统中通过AIDL进行进程之间的通信。
	AIDL的具体使用步骤如下：

###2.AIDL原理

###3.使用步骤

#3.如果对图片进行采样压缩，假设图片是TEST.JPG,请写出简要原理(百度)

#4.Touch事件分发机制(百度)

#5.