package cumt.tj.learn;

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
        System.out.println("整数比较");
        System.out.println(compare(1,2));//-1
        System.out.println(compare(1,3));//-1
        System.out.println(compare(4,1));//1

        short i=1;short j=3;
        System.out.println(compare(Short.valueOf(i),Short.valueOf(j)));//-2

        Byte b1=1;Byte b2=3;
        System.out.println(compare(b1,b2));//-2

        Long l1=Long.valueOf(1);Long l2=Long.valueOf(3);
        System.out.println(compare(l1,l2));//-1

        //浮点数比较
        System.out.println(compare(0.15,0.25));//-1

        //字符串比较
        System.out.println("字符串比较");
        System.out.println("ab".compareTo("ac"));//-1
        System.out.println("ab".compareTo("ad"));//-2
        System.out.println("ac".compareTo("aC"));//32
        System.out.println("ac".compareTo("bc"));//-1
        System.out.println("ad".compareTo("ac"));//1
        System.out.println("bd".compareTo("ad"));//1
        System.out.println("bd".compareTo("bdc"));//-1
        System.out.println("中国".compareTo("中文"));//-1

        //字符比较
        System.out.println("字符比较");
        System.out.println(compare('a','A'));//32
        System.out.println(compare('B','b'));//-31
//        System.out.println(compare('中','国'));//won't compile
//        System.out.println(Character.valueOf('中').compareTo(Character.valueOf('国')));//won't compile
    }

    public static <T extends Comparable<T>> int compare(T i,T j){
        return i.compareTo(j);
    }
}
