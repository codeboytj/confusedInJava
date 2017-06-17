package cumt.tj.learn.generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by sky on 17-6-15.
 * 有限制通配符
 */
public class BoundedWildcardType {

    class Stack<E>{
        public void push(E e){}
        //使用有限制的通配符解决参数化类型的不可变问题
        public void pushAll(Iterator<? extends E> src){
//            这句话是不能编译的，需要将Iterator<E>变为Iterator<? extends E>，这个确实很让人困惑
//            Iterator<E> iterator=src;
            Iterator<? extends E> iterator=src;
        }
        public void popAll(Collection<? super E> src){}
    }

    public static void main(String[] args) {

        Stack<Number> numberStack=new BoundedWildcardType().new Stack<>();

        //这时再插入Iterator<Integer>就没有问题了
        Iterator<Integer> integerIterator=null;
        numberStack.pushAll(integerIterator);

        //这时再弹出到Collection<Object>就没有问题了
        Collection<Object> objectCollection=new ArrayList<>();
        //这样在逻辑上是没有问题的，但是还是通不过编译
        numberStack.popAll(objectCollection);
    }

}
