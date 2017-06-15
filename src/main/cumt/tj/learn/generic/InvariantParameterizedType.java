package cumt.tj.learn.generic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by sky on 17-6-15.
 * 参数化类型的不可变
 */
public class InvariantParameterizedType {

    public static void main(String[] args) {

        //1.参数化类型是不可变的
        List<String> stringList=new ArrayList<>();
//        这句话是不能编译成功的，应为参数化类型是不可变的，List<String>不是List<Object>的子类型
//        List<Object> objectList=stringList;
        List<Object> objectList=new ArrayList<>();

//        但是对于实际类型参数Object，在使用的时候是可以以正常的逻辑，传入它的子类的
        objectList.add("哈哈哈");
        objectList.add(123);
//        String类型是final类，没有子类，只能插入字符串
        stringList.add("wahaha");



        //2.不可变带来的困惑
        //对于一个存储Number的栈
        Stack<Number> numberStack=new Stack<>();
        //如果我插入一个Integer类型的数，就没有任何问题，因为Integer是Number的子类
        numberStack.push(new Integer(123));


        //但是如果我想利用pushAll插入一堆Integer数，于是，我创建了一个Iterator<Integer>，用来装入一堆Integer
        Iterator<Integer> integerIterator=null;
        //然后利用pushAll插进去，这在逻辑上没有问题，但是就会出现问题，根本通不过编译，因为虽然Integer是Number的子类，但是Iterator<Integer>并不是Iterator<Number>的子类
        //这时候就需要使用有限制的通配符来解决这个问题了
//        numberStack.pushAll(integerIterator);
    }

}

class Stack<E>{
    public void push(E e){}
    public void pushAll(Iterator<E> src){}
}