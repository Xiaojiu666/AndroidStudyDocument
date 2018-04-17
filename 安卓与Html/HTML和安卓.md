#1.安卓调用HTML基本操作
-	加载网页内容（WebView.loadUrl()）
	-	1.webView.loadUrl("http://www.google.com/");//方式1. 加载一个网页：
	-	2.webView.loadUrl("file:///android_asset/test.html");//方式2：加载apk包中的html页面
	-	3.webView.loadUrl("content://com.android.htmlfileprovider/sdcard/test.html");///方式3：加载手机本地的html页面
	-	4.WebView.loadData(String data, String mimeType, String encoding); // 方式4： 加载 HTML 页面的一小段内容
-	WebView状态

        webView.onResume()
		//激活WebView为活跃状态，能正常执行网页的响应
    	webView.onPause()；
		//当页面被失去焦点被切换到后台不可见状态，需要执行onPause
		//通过onPause动作通知内核暂停所有的动作，比如DOM的解析、plugin的执行、JavaScript执行。
    	webView.pauseTimers()
		//当应用程序(存在webview)被切换到后台时，这个方法不仅仅针对当前的webview而是全局的全应用程序的webview
		//它会暂停所有webview的layout，parsing，javascripttimer。降低CPU功耗。
    	webView.resumeTimers()；
		//恢复pauseTimers状态

    	rootLayout.removeView(webView); 
    	webView.destroy();
       	//销毁Webview 
		//在关闭了Activity时，如果Webview的音乐或视频，还在播放。就必须销毁Webview 
		//但是注意：webview调用destory时,webview仍绑定在Activity上 
		//这是由于自定义webview构建时传入了该Activity的context对象 
		//因此需要先从父容器中移除webview,然后再销毁webview: rootLayout.removeView(webView);
- 页面的前进和后退

    		Webview.canGoBack() 
			//是否可以后退
		Webview.goBack()
			//后退网页
		Webview.canGoForward()
			//是否可以前进  
		Webview.goForward()
			//前进网页
		Webview.goBackOrForward(intsteps) 
			//以当前的index为起始点前进或者后退到历史记录中指定的steps
			//如果steps为负数则为后退，正数则为前进

-	清除数据
	
        Webview.clearCache(true);
    	//清除网页访问留下的缓存
    	//由于内核缓存是全局的因此这个方法不仅仅针对webview而是针对整个应用程序.
    	Webview.clearHistory()；
    	//清除当前webview访问的历史记录
    	//只会webview访问历史记录里的所有记录除了当前访问记录
    	Webview.clearFormData()；
    	//这个api仅仅清除自动完成填充的表单数据，并不会清除WebView存储到本地的数据
    
-	WebSetting类（对WebView进行管理和配置）
	
	    //声明WebSettings子类 
		WebSettings webSettings = webView.getSettings();
		//如果访问的页面中要与Javascript交互，则webview必须设置支持Javascript 
		webSettings.setJavaScriptEnabled(true); 
		// 若加载的 html 里有JS 在执行动画等操作，会造成资源浪费（CPU、电量） 
		// 在 onStop 和 onResume 里分别把 setJavaScriptEnabled() 给设置成 false 和 true 即可 
		//支持插件 
		webSettings.setPluginsEnabled(true); 
		//设置自适应屏幕，两者合用 
		webSettings.setUseWideViewPort(true); 
		//将图片调整到适合webview的大小 
		webSettings.setLoadWithOverviewMode(true); 
		//缩放至屏幕的大小 
		//缩放操作 w
		ebSettings.setSupportZoom(true); 
		//支持缩放，默认为true。是下面那个的前提。 
		webSettings.setBuiltInZoomControls(true); 
		//设置内置的缩放控件。若为false，则该WebView不可缩放 
		webSettings.setDisplayZoomControls(false); 
		//隐藏原生的缩放控件 
		//其他细节操作 
		webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK); 
		//关闭webview中缓存 
		webSettings.setAllowFileAccess(true); 
		//设置可以访问文件 
		webSettings.setJavaScriptCanOpenWindowsAutomatically(true); 
		//支持通过JS打开新窗口 
		webSettings.setLoadsImagesAutomatically(true); 
		//支持自动加载图片 
		webSettings.setDefaultTextEncodingName("utf-8");
		//设置编码格式
		webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALW
		//5.1以上默认禁止了https和http混用 这是开启

- 当加载 html 页面时，WebView会在/data/data/包名目录下生成 database 与 cache 两个文件夹
请求的 URL记录保存在 WebViewCache.db，而 URL的内容是保存在 WebViewCache 文件夹下	
	
	    //优先使用缓存:
    	 WebView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK); 
    	//缓存模式如下：
    		 //LOAD_CACHE_ONLY: 不使用网络，只读取本地缓存数据 
    		 //LOAD_DEFAULT: （默认）根据cache-control决定是否从网络上取数据。 
    		 //LOAD_NO_CACHE: 不使用缓存，只从网络获取数据. 
    		 //LOAD_CACHE_ELSE_NETWORK，只要本地有，无论是否过期，或者no-cache，都使用缓存中的数据。 
    		 //不使用缓存: 
    	WebView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);


- WebViewClient(处理各种事件和请求)

	- 1.shouldOverrideUrlLoading() //将网页加载本WebView 而不是浏览器打开
	- 2.onPageStarted()  //页面开始时调用
	- 3.onPageFinished()  //页面结束时调用
	- 4.onLoadResource() //加载资源文件
	- 5.onReceivedError() //App里面使用webview控件的时候遇到了诸如404这类的错误的时候，若也显示浏览器里面的那种错误提示页面就显得很丑陋了，那么这个时候我们的app就需要加载一个本地的错误提示页面，即webview如何加载一个本地的页面
	- 6.onReceivedSslError() //webView默认是不处理https请求的，页面显示空白，需要进行如下设置：

	    	mWebView.setWebViewClient(new WebViewClient() {
		    @Override
		    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
		    handler.proceed();
		    //表示等待证书响应 
		    // handler.cancel(); 
		    // 表示挂起连接，为默认方式 
		    // handler.handleMessage(null); 
		    // 可做其他处理 
		    }
		    });
		    // 特别注意：5.1以上默认禁止了https和http混用，以下方式是开启 
		    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
		    mWebView.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
		    }
	
- WebChromeClient(辅助 WebView 处理 Javascript 的对话框,网站图标,网站标题等等)
	-  1.onProgressChanged() //获得网页的加载进度并显示
	-  2.onReceivedTitle（） //获取网页标题
	-  3.onJsAlert() //支持javascript的警告框
	-  4.onJsConfirm（）//支持javascript的确认框
	-  5.onJsPrompt（） //支持javascript输入框


-	注意事项
	-	1.内存泄露
		-	不在xml中定义 Webview ，而是在需要的时候在Activity中创建，并且Context使用 getApplicationgContext()
		-	在 Activity 销毁（ WebView ）的时候，先让 WebView 加载null内容，然后移除 WebView，再销毁 WebView，最后置空。
	

    
#2.Android调用Html中的JS
-	1.设置webSetting

    	WebSettings webSettings = mWebView.getSettings();
		webSettings.setJavaScriptEnabled(true);// 设置与Js交互的权限
		webSettings.setJavaScriptCanOpenWindowsAutomatically(true);// 设置允许JS弹窗
	

-	2.调用HTML中的JS方法
	
		     mWebView.loadUrl("javascript:callJS()");
		     mWebView.evaluateJavascript("javascript:callJS()", new ValueCallback<String>() {
		   		 @Override
		    		public void onReceiveValue(String value) {
		    		//此处为 js 返回的结果
		    		KLog.e("js 返回的结果" + value);
		   		 }
		    });


-	3.使用WebChromClient对象中的onJsAlert方法，获取Alert值


#3.JS调用安卓
	通过WebView的addJavascriptInterface（）进行对象映射
	通过 WebViewClient 的shouldOverrideUrlLoading ()方法回调拦截 url
	通过 WebChromeClient 的onJsAlert()、onJsConfirm()、onJsPrompt（）方法回调拦截JS对话框alert()、confirm()、prompt（） 消息

- 1.通过WebView的addJavascriptInterface（）进行对象映射(简单,传值更便捷 但是容易出漏洞)
	-	1.创建一个类用于与JS中的方法进行绑定
	
		// 定义JS需要调用的方法
	    // 被JS调用的方法必须加入@JavascriptInterface注解
	    @JavascriptInterface
	    public void hello(String msg) {
	    KLog.e("JS调用了Android的hello方法");
	     //   System.out.println("JS调用了Android的hello方法");
	    }
	-	2.Html

		<html>
		<head>
	    <meta charset="utf-8">
	    <title>Carson</title>
	    <script>
	    function callAndroid()
	    {
	        test.hello("js调用了android中的hello方法");
	     }
	    </script>
		</head>
		<body>
			<button type="button" id="button1" onclick="callAndroid()">JS的点击按钮</button>
		</body>
		</html>
		
	-	3.引用
		-	方法一:使用简单仅将Android对象和JS对象映射即可，
		-	缺点：https://www.jianshu.com/p/3a345d27cd42
		
	    	    // 通过addJavascriptInterface()将Java对象映射到JS对象 
    			//参数1：Javascript对象名 
    			//参数2：Java对象名 
    			mWebView.addJavascriptInterface(new AndroidtoJs(), "test");
    			//AndroidtoJS类对象映射到js的test对象 
    			// 加载JS代码 
    			// 格式规定为:
    			file:///android_asset/文件名.html mWebView.loadUrl("file:///android_asset/javascript.html");


- 2 通过 WebViewClient 的方法shouldOverrideUrlLoading ()回调拦截 url(繁琐 没有漏洞 不方便传递数据)
	- 1.Android通过 WebViewClient 的回调方法shouldOverrideUrlLoading ()拦截 url
	- 2.解析Url的协议
	- 3.Html
	
	    	function callAndroid()
	    	{
	    	<!-- method2-->
			//设置URL 
			//  KLog.e(uri.toString()); Uri地址
                KLog.e(uri.getScheme()); 协议格式
                KLog.e(uri.getAuthority()); 协议名称 
				uri.getQueryParameterNames() 协议后的参数HasMap类型 下面的size =3 
	    	document.location = "js://www.baidu.com?userName=11&password=33&token=111";
	    	<!-- method1-->
	    	<!--test.hello("js调用了android中的hello方法");-->
	     	}	
	    