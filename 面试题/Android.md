###1.JVM和DVM的区别
	1.	JVM，
		1.	JVM基于栈，栈是内存上面的一段连续的存储空间
		2.	JVM是Oracle公司
		3.	java文件 -> .class文件 -> .jar文件
		4.	![avatar](https://img-blog.csdn.net/20161104122858683?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center)
	2.	
		1.	DVM，Dalvik Virtual Machine  Dalvik基于寄存器 Dalvik经过优化，允许在有限的内存中同时运行多个虚拟机的实例，并且每一个 Dalvik应用作为一个独立的Linux进程执行。独立的进程可以防止在虚拟机崩溃的时候所有程序都被关闭。寄存器是CPU上面的一块存储空间
		2.	Google
		3.	java文件 –> .class文件 -> .dex文件
