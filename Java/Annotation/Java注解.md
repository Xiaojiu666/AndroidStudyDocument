## 注解的基础
##### 注解的背景: 注解、标志@ 。针对java不同版本来说，注解的出现是在jdk1.5 但是在jdk1.5版本使用注解必须继续类的方法的重写，不能用于实现的接口中的方法实现，在jdk1.6环境下对于继续和实现都实用。java1.5内置注解
- @Override，表示当前的方法定义将覆盖父类中的方法。
- @Deprecated，使用了注解为它的元素编译器将发出警告，因为注解@Deprecated是不赞成使用的代码，被弃用的代码。
- @SuppressWarnings,关闭不当编辑器警告信息。

##### 注解的定义：Java文件叫做Annotation，用@interface表示。
##### 元注解：@interface上面按需要注解上一些东西，包括@Retention、@Target、@Document、@Inherited四种。
##### 注解的保留策略 Retention（表示需要在什么级别保存该注解信息)：
- @Retention(RetentionPolicy.SOURCE)   // 注解仅存在于源码中，在class字节码文件中不包含
- @Retention(RetentionPolicy.CLASS)     // 默认的保留策略，注解会在class字节码文件中存在，但运行时无法获得
- @Retention(RetentionPolicy.RUNTIME)  // 注解会在class字节码文件中存在，在运行时可以通过反射获取到

##### 注解的作用目标 Target(表示该注解可以用于什么地方)：

- @Target(ElementType.TYPE)                    // 接口、类、枚举、注解
- @Target(ElementType.FIELD)                   // 字段、枚举的常量
- @Target(ElementType.METHOD)                  // 方法
- @Target(ElementType.PARAMETER)               // 方法参数
- @Target(ElementType.CONSTRUCTOR)             // 构造函数
- @Target(ElementType.LOCAL_VARIABLE)          // 局部变量
- @Target(ElementType.ANNOTATION_TYPE)         // 注解
- @Target(ElementType.PACKAGE)                 // 包

##### 注解包含在javadoc中 Document (将注解包含在Javadoc中)：
- @Documented

##### 注解可以被继承 Inherited (允许子类继承父类中的注解):
- @Inherited

##### 注解解析器：用来解析自定义注解。
