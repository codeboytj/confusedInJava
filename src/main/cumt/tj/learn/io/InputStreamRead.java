package main.cumt.tj.learn.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by sky on 17-7-20.
 * 问题：io字节流中的read()方法，当没有字节可读的时候返回-1，那么平时读字节的时候，难道不会读到“-1”这个字节(0xff)？
 * 通过输出，发现把0xff读成255，按照无符号数转换的
 */
public class InputStreamRead {

    public static void main(String[] args) {
        try {
            FileOutputStream output = new FileOutputStream("test.dat");

            //写入-1,二进制为1111 1111，即ff
            output.write((byte)-1);
            output.write((byte)2);
            output.write((byte)3);
            output.write((byte)4);
            output.write((byte)5);

            BufferedInputStream input = new BufferedInputStream(new FileInputStream("test.dat"));

            int i;
            while ((i = input.read()) != -1) {
                //对于写入的ff,read()读取的时候转换成了255，就是说读取的时候当成无符号数读取的
                System.out.println(i);
            }
        } catch (IOException ex) {
            System.out.println(ex.getStackTrace());
        }
    }

}
