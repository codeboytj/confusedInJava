# 字符串的困惑

## 字符串连接与StringBuilder.append()方法

### 字符串共享池

JVM中会有一个字符串共享池，所有通过创建字符串常量方式创建的字符串都会放到字符串共享池之中，如StringEquals.main()中看到的那样，a==b的结果为true，就是因为他们指向的是共享池中的同一个字符串常量

不管是通过字符串连接产生的字符串还是StringBuilder.append().toString()方法产生的字符串，都不是放到共享池之中的。如今的java编译器会把java代码中的字符串拼接的代码自动转换成使用StringBuilder.append().toString()的东东。而通过查看StringBuilder的源代码可以发现，它的toString()方法是通过调用String的构造函数String(,,)生成字符串的。所以它产生的字符串是在堆里面的，所以调用"=="判断会显示false。