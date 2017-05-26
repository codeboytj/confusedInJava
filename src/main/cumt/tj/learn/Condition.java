package cumt.tj.learn;

/**
 * Created by sky on 17-5-26.
 * 条件运算符：(condition)？expression1:expression2
 * 令人容易混淆的是：condition为true的时候，到底执行那个表达式？
 */
public class Condition {
    public static void main(String[] args) {
        int a=1;int b=2;int c=3;
        System.out.print((a==b)?b:c);
    }
}
