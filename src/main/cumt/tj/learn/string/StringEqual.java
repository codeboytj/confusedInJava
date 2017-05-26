package cumt.tj.learn.string;

/**
 * Created by sky on 17-5-25.
 */
public class StringEqual {
    public static void main(String[] args) {
        String a="abc";
        String b="abc";
        String c=a+b;
        String d=a+b;
        System.out.println("a:"+a+",b:"+b+",a=b:"+(a==b)+",c:"+c+",d:"+d+",d=c"+(d==c));

        b="abb";
        System.out.println("a:"+a+",b:"+b+",a=b:"+(a==b));
    }
}
