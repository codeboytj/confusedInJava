package cumt.tj.learn.exception;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by sky on 17-6-12.
 * 处理异常的时候可以通过throw抛出异常，也可以通过catch语句抓住异常，然后进行特定的操作
 * 然而我想看看throw与catch语句，经过编译而成的code属性有什么不同
 */
public class ThrowAndCatch {

    public static void throwAway() throws FileNotFoundException {
        BufferedReader br=new BufferedReader(new FileReader("./source.md"));
    }

    public static void catchIt(){
        try {
            BufferedReader br=new BufferedReader(new FileReader("./source.md"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 不错，还可以一边抛，一边抓
     * 所以虚拟机在处理抛出异常的方法的时候异常的时候，要先看看方法内部有没有处理该异常的东东
     * @throws FileNotFoundException
     */
    public static void catchAndThrowIt() throws FileNotFoundException {
        try {
            BufferedReader br=new BufferedReader(new FileReader("./source.md"));
        } catch (FileNotFoundException e) {
            System.out.println("handle in catchAndThrowIt");
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        catchIt();
        try {
            throwAway();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            catchAndThrowIt();
            //这段代码，最终只打印了handle in catchAndThrowIt，而没有打印handle in main
            // 说明虚拟机先去catchAndThrowIt()的异常处理表找能处理的东东，处理完了就不再处理第二遍了
        } catch (FileNotFoundException e) {
            System.out.println("handle in main");
            e.printStackTrace();
        }
    }

}
