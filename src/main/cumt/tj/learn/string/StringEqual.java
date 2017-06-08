package cumt.tj.learn.string;

/**
 * Created by sky on 17-5-25.
 */
public class StringEqual {

    public static boolean isPlusTheSame(String s1,String s2){
        String a=s1+s2;
        String b=s1+s2;
        return a==b;
    }

    public static boolean isPlusEquals(String s1,String s2){
        String a=s1+s2;
        String b=s1+s2;
        return a.equals(b);
    }

    public static boolean isAppendThsSame(String s1,String s2){
        String a=new StringBuilder(s1).append(s2).toString();
        String b=new StringBuilder(s1).append(s2).toString();
        return a==b;
    }

    public static boolean isAppendEquals(String s1,String s2){
        String a=new StringBuilder(s1).append(s2).toString();
        String b=new StringBuilder(s1).append(s2).toString();
        return a.equals(b);
    }

    public static void main(String[] args) {
        String a="abc";
        String b="abc";
        System.out.println(a==b);
        System.out.println(a.equals(b));

        System.out.println("两个字符串相加分别赋值给两个不同的引用，用“==”符号判断是否相等"+isPlusTheSame("abc","efg"));
        System.out.println("两个字符串相加分别赋值给两个不同的引用，用equals方法符号判断是否相等"+isPlusEquals("abc","efg"));
        System.out.println("两个字符串利用StringBuilder.append分别赋值给两个不同的引用，用"=="方法符号判断是否相等"+isAppendThsSame("abc","efg"));
        System.out.println("两个字符串利用StringBuilder.append分别赋值给两个不同的引用，用equals方法符号判断是否相等"+isAppendEquals("abc","efg"));

    }
}
