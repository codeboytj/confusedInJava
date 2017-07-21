package main.cumt.tj.learn.io;

import java.io.*;

/**
 * Created by sky on 17-7-20.
 * 读取文件中的文本
 */
public class ReadText {

    private static void writeFile(String fileName) throws FileNotFoundException {
        //
        PrintWriter out=new PrintWriter(fileName);
        out.write("123 safas 3233 sdfewwe");
        out.close();
    }

    public static void main(String[] args) throws IOException {
        String fileName="test.txt";
        writeFile(fileName);
        BufferedReader br=new BufferedReader(
                new FileReader(fileName)
        );
//        String line;
//        while ((line=br.readLine())!=null){
//            System.out.print(line);
//        }
        int c;
        while ((c=br.read())!=-1){
            System.out.print((char)c);
        }
        br.close();
    }

}
