##1.Handler
- handler:用作与子线程和主线程通信，在新启动的线程中发送消息，在主线程中获取并处理信息

##2.Message
- 消息，理解为线程间通讯的数据单元（Handler接受和处理的消息对象。）子线程和主线程通讯的对象

##3.Message Queue
- 消息队列，定义：消息队列，作用：用来存放通过Handler发过来的消息，按照先进先出执行

##4.Looper
- 定义：循环器，扮演Message Queue和Handler之间桥梁的角色 ， 作用：主要负责消息循环：循环取出Message Queue的Message；消息派发：将取出的Message交付给相应的Handler
- 源码作用:
	- 实例化本身、与当前线程绑定、创建与之相应的MessageQueue：prepare()方法（一个线程只会有一个Looper实例，同时一个Looper实例也只有一个MessageQueue）
	- 消息循环（消息取出、消息派发）：loop()方法
不断从MessageQueue中去取消息，派发给消息的target属性的Handler，然后调用相应Handler的dispatchMessage()方法进行消息处理。


##5.存在关系
- Thread、Looper、Handler之间的对应关系：
	- 一个Thread（线程）只能有一个Looper，可以有多个Handler
	- 一个Looper可以绑定多个Handler；
	- 一个Handler只能绑定一个Looper；

## 6.使用方法
- 可以在子线程里直接用sendMessage（），在Handler对象里重写handleMessage()方法，拿到Message对象，并且取到值
- 在子线程里调用Handler的post方法，传一个Runable对象，直接在run方法里更改布局操作

## 7.可能会发生内存泄露原因与监测
- 原因:
	- *主线程的Looper对象的生命周期 = 该应用程序的生命周期
    - *在Java中，非静态内部类 & 匿名内部类都默认持有 外部类的引用
	- 在Handler消息队列 还有未处理的消息 / 正在处理消息时，消息队列中的Message持有Handler实例的引用
	- 由于Handler = 非静态内部类 / 匿名内部类（2种使用方式），故又默认持有外部类的引用（即MainActivity实例），
	- 所以当Acticity需要销毁的时候，GC无法回收页面，导致内存泄露
- 解决办法：
	- 存在“未被处理 / 正处理的消息 -> Handler实例 -> 外部类” 的引用关系
    - Handler的生命周期 > 外部类的生命周期
	- 将activity改为若引用
	- 当外部类结束生命周期时，清空Handler内消息队列
    @Override 
	protected void onDestroy() 
	{ 
	super.onDestroy(); mHandler.removeCallbacksAndMessages(null); 
	// 外部类Activity生命周期结束时，同时清空消息队列 & 结束Handler生命周期 
	}



