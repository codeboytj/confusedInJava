package cumt.tj.learn.string;

/**
 * Created by sky on 17-5-25.
 */
public class StringLength {
    public static void main(String[] args) {
        String s="中国人";
        System.out.println(s.length());
        System.out.println(s.offsetByCodePoints(0,1));
        System.out.println(s.codePointAt(s.offsetByCodePoints(0,2)));
        System.out.println(s.codePointAt(1));
        System.out.println(s.codePointAt(2));
        System.out.println(s.codePointAt(3));
        System.out.println(s.codePointAt(4));
        int count=s.codePointCount(0,s.length());
        System.out.println(count);
        System.out.println(s.charAt(0));
        System.out.println(s.charAt(1));
        System.out.println(s.charAt(2));
        System.out.println(s.charAt(3));
        System.out.println(s.charAt(4));
    }
}
