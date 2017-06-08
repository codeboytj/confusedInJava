package cumt.tj.learn;

import java.util.Arrays;

/**
 * Created by sky on 17-6-8.
 * 在取字符串的子字符串的时候，经常会困惑，到底是从参数的位置取还是从参数+1的位置开始取值，也就是左闭右开还是左开右闭，或者一起开还是一起闭的问题
 */
public class OpenOrClosedInterval {

//    public static
    public enum IntervalClosedType{
        //左闭右开
        LEFT,
        //左开右闭
        RIGHT,
        //全闭
        ALL,
//        全开
        NONE
    }

    public static IntervalClosedType stringClosedType(){
        String s="01234567";
        String s1=s.substring(3,5);

        switch (s1){
            case "345" :return IntervalClosedType.ALL;
            case "34" :return IntervalClosedType.LEFT;
            case "45" :return IntervalClosedType.RIGHT;
            case "4" :return IntervalClosedType.NONE;
            default:return null;
        }

    }

    public static IntervalClosedType arrayClosedType(){

        int[] numbers={0,1,2,3,4,5,6,7};
        int[] subArray= Arrays.copyOfRange(numbers,3,5);

        switch (subArray[0]){
            case 3:switch (subArray[subArray.length-1]){
                case 5:return IntervalClosedType.ALL;
                case 4:return IntervalClosedType.LEFT;
            }
            case 4:switch (subArray[subArray.length-1]){
                case 5:return IntervalClosedType.RIGHT;
                case 4:return IntervalClosedType.NONE;
            }
            default:return null;
        }
    }

    public static void main(String[] args) {
        System.out.print(stringClosedType()+"闭");//LEFT
        System.out.print(arrayClosedType()+"闭");//LEFT
        //结果显示都是左闭右开
    }
}
