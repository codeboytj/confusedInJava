# Java中易混淆的知识点

## Comparable接口

### compareTo()方法

这个方法有三个返回值-1,0,1。0表示相等没有悬念，容易混淆的是-1与1分别表示谁大谁小：

在cumt.tj.learn.ComparableConfused.java中，通过打印i.comparaTo(j)的结果得出：

- -1 表示方法的调用者，也就是i更小，方法的实参j更大
- 1 则与-1相反

另外，发现字符串的比较是按字典序进行的。
