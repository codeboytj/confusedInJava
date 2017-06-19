package cumt.tj.learn.generic;

import java.util.List;

/**
 * Created by sky on 17-6-17.
 * 泛型数组的困惑
 */
public class GenericArray<T> {

    public static class ParameterizedTypeArray<F>{

        //1.不能创建带有参数化类型的数组
        //这是不能编译通过的，因为擦除会擦掉泛型的类型信息，而数组必须知道确切的类型信息，以保证类型安全
//        List<String>[] stringList=new List<String>[10];

        //2. 但是，却能够参数化数组本身的类型，如T[]
        //这是Java编程思想里面的一段话，实在看不出来1和2有什么转折关系
        public void createGenericArray(){
            Integer[] integers=create(new Integer[]{1,2,3,4,5,6});
            Integer[] integers1=create(new Integer[4]);

            //对于类型参数T，由于擦除，不能创建关于它的数组T[]，这是不能通过编译的
//          F[] fs=new F[20];
            //所以，想要创建泛型数组T[]，就需要先创建一个Object[]，然后对其进行强制转换
            F[] fs=(F[])new Object[20];
        }

        /*
        使用泛型方法而不是泛型类会带来很多的灵活性：
        1. 不必为每一个不同的类型去实例化一个类
        2. 可以把泛型方法定义为静态的
         */
        public static <E> E[] create(E[] arg){
            return arg;
        }

        public void createParameterizedTypeArray(){

            //1. 创建参数化类型的数组的一种方法
            //虽然不能创建带有参数化类型的数组，但是可以创建这种数组的引用：
            List<String>[] stringList;
            //但是创建一个非泛型的原生类型数组
            List[] lists=new List[20];
            //然后将其强制转换
            stringList=(List<String>[])lists;

        }
    }

    public void createGenericArray(){
        int size=10;
//        这是不能编译通过的，因为擦除会擦掉泛型的类型信息，而数组必须知道确切的类型信息，以保证类型安全
//        T[] arr=new T[10];
//        但是却能够创建一个泛型数组引用
        T[] arr;
    }

    public static void main(String[] args) {
    }
}
