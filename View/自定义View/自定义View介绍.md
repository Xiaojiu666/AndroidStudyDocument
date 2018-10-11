#一、介绍
###1.简介
	为什么要自定义View，

###2.类

###3.方法

###4.属性

###5.使用步骤

#二、自定义属性
###步骤:
- 1.配置：在res/values中的attrs.xml中自定义属性。

    
   		 <declare-styleable name="TestView"> 
    		<attr name="attrone" format="dimension"/>
    			<attr name="attrtwo" format="string" > 
    			<enum name="one" value="0"/> 
    		<enum name="two" value="1"/> 
    		</attr> 
 	   	</declare-styleable>
    

- 2.使用：首先加入命名空间：xmlns:app="http://schemas.android.com/apk/res-auto"

	    <com.mg.axe.androiddevelop.view.TestView 
			android:layout_width="match_parent" 
			android:layout_height="match_parent" 
			app:attrone="10dp" 
			app:attrtwo="two" />


- 3.自定义View里获取自定义属性

		TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.TestView); 
		float attrone = ta.getDimension(R.styleable.TestView_attrone,0); 
		String attrTwo = ta.getString(R.styleable.TestView_attrtwo); 


- 4.赋值


#三、自定义画板