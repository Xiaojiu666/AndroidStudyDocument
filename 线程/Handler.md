####	1.Handler
- handler:用作与子线程和主线程通信，在新启动的线程中发送消息，在主线程中获取并处理信息
- 源码分析：handler扮演了往MQ上添加消息和处理消息的角色（只处理由自己发出的消息），即通知MQ它要执行一个任务(sendMessage)，并在loop到自己的时候执行该任务(handleMessage)，整个过程是异步的。handler创建时会关联一个looper，默认的构造方法将关联当前线程的looper，不过这也是可以set的

####	2.Message
- 消息，理解为线程间通讯的数据单元（Handler接受和处理的消息对象。）子线程和主线程通讯的对象

####	3.Message Queue
- 消息队列，定义：消息队列，作用：用来存放通过Handler发过来的消息，按照先进先出执行

####	4.Looper
- 定义：循环器，扮演Message Queue和Handler之间桥梁的角色 ， 作用：主要负责消息循环：循环取出Message Queue的Message；消息派发：将取出的Message交付给相应的Handler
- 源码作用:
	- 实例化本身、与当前线程绑定、创建与之相应的MessageQueue：prepare()方法（一个线程只会有一个Looper实例，同时一个Looper实例也只有一个MessageQueue）
	- 消息循环（消息取出、消息派发）：loop()方法
不断从MessageQueue中去取消息，派发给消息的target属性的Handler，然后调用相应Handler的dispatchMessage()方法进行消息处理。
- 源码分析：
	- 1.Looper的字面意思是“循环者”，它被设计用来使一个普通线程变成Looper线程，使用方法就是让继承普通线程，在run方法中 调用Looper.prepare（），进行初始化，调用Looper.loop()开始循环
	- 2.Looper.prepare（），通过源码发现一个线程只能有一个Looper ，并且在Looper内部维护了一个MQ队列，其核心就是将looper对象定义为ThreadLocal。

	```

				// 每个Looper对象中有它的消息队列，和它所属的线程
			    private Looper() {
			        mQueue = new MessageQueue();
			        mRun = true;
			        mThread = Thread.currentThread();
			    }

			    // 我们调用该方法会在调用线程的TLS中创建Looper对象
			    public static final void prepare() {
			        if (sThreadLocal.get() != null) {
			            // 试图在有Looper的线程中再次创建Looper将抛出异常
			            throw new RuntimeException("Only one Looper may be created per thread");
			        }
			        sThreadLocal.set(new Looper());
			    }
	```
	- 3.Looper.loop（），普通线程好比一条直的马路， Looper.prepare()将在马路上建立一条跑道(MQ)，Looper.loop（）将直线的跑道变成一个循环的圆形跑道，Handler好比边上的调度站，用来线程之间的通讯，Handler 通过各种方法，最后调用MQ的enqueueMessage方法往跑道里放入跑车。

	```

	 	 while (true) {
	            Message msg = queue.next(); // 取出message
	            if (msg != null) {
	                if (msg.target == null) {
	                    // message没有target为结束信号，退出循环
	                    return;
	                }
	                // 日志。。。
	                if (me.mLogging!= null) me.mLogging.println(
	                        ">>>>> Dispatching to " + msg.target + " "
	                        + msg.callback + ": " + msg.what
	                        );
	                // 非常重要！将真正的处理工作交给message的target，即后面要讲的handler
	                msg.target.dispatchMessage(msg);
	                // 还是日志。。。
	                if (me.mLogging!= null) me.mLogging.println(
	                        "<<<<< Finished to    " + msg.target + " "
	                        + msg.callback);

	                // 下面没看懂，同样不影响理解
	                final long newIdent = Binder.clearCallingIdentity();
	                if (ident != newIdent) {
	                    Log.wtf("Looper", "Thread identity changed from 0x"
	                            + Long.toHexString(ident) + " to 0x"
	                            + Long.toHexString(newIdent) + " while dispatching to "
	                            + msg.target.getClass().getName() + " "
	                            + msg.callback + " what=" + msg.what);
	                }
	                // 回收message资源
	                msg.recycle();
	            }
	```


####	MessageQueue中的IdleHandler
-	https://blog.csdn.net/tencent_bugly/article/details/78395717

####	5.存在关系
- Thread、Looper、Handler之间的对应关系：
	- 一个Thread（线程）只能有一个Looper，可以有多个Handler(通过prepare源码进行观察得出结论)
	- 一个Looper可以绑定多个Handler；()
	- 一个Handler只能绑定一个Looper；

#### 6.使用方法
- 可以在子线程里直接用sendMessage（），在Handler对象里重写handleMessage()方法，拿到Message对象，并且取到值
- 在子线程里调用Handler的post方法，传一个Runable对象，直接在run方法里更改布局操作

#### 7.可能会发生内存泄露原因与监测
- 原因:
	- /主线程的Looper对象的生命周期 = 该应用程序的生命周期
    在Java中，非静态内部类 & 匿名内部类都默认持有 外部类的引用
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


#### 8. 参考资料
1.http://www.cnblogs.com/codingmyworld/archive/2011/09/12/2174255.html
