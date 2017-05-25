package cumt.tj.learn;

import com.sun.org.apache.xml.internal.utils.StringComparable;

/**
 * Created by sky on 17-5-25.
 * Comparable接口的compare()To方法返回结果代表的意思容易弄混淆
 * 返回结果为0时表示相等
 * 返回结果大于0时表示的是谁大？
 * 返回结果小于0时表示的是谁小？
 */
public class ComparableConfused {
    public static void main(String[] args) {
        //整数比较
        System.out.println(integerComparable(1,2));

        //字符串比较
        System.out.println("ab".compareTo("ac"));
        System.out.println("ab".compareTo("ad"));
        System.out.println("ac".compareTo("ad"));
        System.out.println("ac".compareTo("bc"));
        System.out.println("ad".compareTo("ac"));
        System.out.println("bd".compareTo("ad"));

    }

    public static int stringComparable(String s1,String s2){
        return s1.compareTo(s2);
    }

    public static int integerComparable(Integer i,Integer j){
        return i.compareTo(j);
    }
}
