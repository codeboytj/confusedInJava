package main.cumt.tj.learn.io;

import java.util.Scanner;

/**
 * Created by sky on 17-7-21.
 * 从运行的结果来看，调用hasXXX()方法,如果输入流里面没东西,开始阻塞，等待用户输入回车生成输入流，结束阻塞
 * 读取输入流，判断是否有相应的东西(Int、line * 之类的），然后调用nextXXX()的时候，根据相应分隔符读出。
 * 直到读完输入流，循环中的hasXXX方法又将发生阻塞，等待用户按回车生成输入流
 * 所以需要定义一个结束读取的东西（如exit字符串）和良好利用hasNextInt之类的方法
 * 否则(hasNext()与hasNextLine()方法)很容易一直等待输入的程序
 */
public class ScanConsole {

    static Scanner sc=new Scanner(System.in);
    /**
     * 逐行打印输入的每行数据
     */
    private static void scanByLine(){

        System.out.println("请输入数据，按回车结束每行输入");

        //扫描控制台输入

        String line;
        while (sc.hasNextLine()){
            line=sc.nextLine();
            //打印输入的每行数据
            System.out.println(line);
            if(line.equals("exit")){
                //输入exit退出
                break;
            }
        }

    }

    private static void scanByWord(){

        System.out.println("请输入数据，按空格结束每个单词输入");

        int number;
        while (sc.hasNextInt()){
            number=sc.nextInt();
            //打印输入的每个单词
            System.out.println(number);
        }

//        把这段话注释的话，在输入一行数据中，如果有非int，会跳出hasNextInt()循环,提前结束
//        String word;
//        while (sc.hasNext()){
//            word=sc.next();
//            if(word.equals("exit")){
//                //输入exit退出
//                break;
//            }
//        }

    }

    public static void main(String[] args) {

        scanByLine();

        scanByWord();

        sc.close();

    }

}
