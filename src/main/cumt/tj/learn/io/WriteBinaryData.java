package main.cumt.tj.learn.io;

import java.io.*;

/**
 * Created by sky on 17-7-20.
 * 利用字节流，直接根据数据类型写数据
 */
public class WriteBinaryData {

    public static void main(String[] args) {
        try {
            DataOutputStream out=new DataOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream("test.dat")));

            out.writeBoolean(true);
            out.writeByte(-1);
            out.writeUTF("asf");
            out.close();
//            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
