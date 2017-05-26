# Java中易混淆的知识点

## Comparable接口

### compareTo()方法

这个方法有三个返回值-1,0,1。0表示相等没有悬念，容易混淆的是-1与1分别表示谁大谁小：

在cumt.tj.learn.ComparableConfused.java中，通过打印i.compareTo(j)的结果得出：

- 结果为正时，表示方法的调用者，也就是i更小，方法的实参j更大
- 结果为负时，与结果为正时相反

另外，可以发现不同类的compareTo()方法实现是不一样的。

#### 整形的比较

##### Integer,Long

int与long的比较，只有-1,0,1三种结果，表示<,>,=

##### Byte,Short,Character

byte,short与char返回的结果，是两个数值相减的结果，值得一提的是，比较中文字符的时候会直接出现编译错误

##### 字符串的比较

通过阅读源码，发现字符串的比较，是通过比较底层的字符数组实现的

1. 逐一比较字符数组相同索引位的char，如果不相等，就返回该索引位char比较的值，也就是相减的结果，这就是字符串比较的结果
2. 如果字符数组长度小的那个数组已经遍历完了，但还没有找到不相等的char，那么就返回两个char数组长度相减的结果，也就是说，如果实参长度大，结果就返回负

## 条件运算符

条件运算符：(condition)？expression1:expression2，令人容易混淆的是：condition为true的时候，到底执行那个表达式？

通过cumt.tj.learn.Condition.java的打印结果为3，所以condition为true的时候执行的是expression1。
