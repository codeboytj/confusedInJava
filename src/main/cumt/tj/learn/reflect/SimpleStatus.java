package cumt.tj.learn.reflect;

/**
 * Created by sky on 17-6-5.
 * 一个极其简单的运行状态，jvm中只有java.lang.Class与java.lang.Object两个类的实例
 */
public class SimpleStatus {
    public static void main(String[] args) {
        Object o1=new Object();
        Class o2=o1.getClass();
        Class o3=o2.getClass();
        Class sc=String.class;

        System.out.println(o2.getName());
        System.out.println(o3.getName());
        System.out.println(sc.getName());
    }
}
