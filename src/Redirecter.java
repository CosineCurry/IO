//例程18-16 Redirecter.java
import java.io.*;
public class Redirecter {
    /**  为标准重定向 */
    public static void redirect(InputStream in,PrintStream out,PrintStream err) {
        System.setIn(in);
        System.setOut(out);
        System.setErr(err);
    }

    /** 把来自标准输入流的数据写到标准输出流和标准错误输出流 */
    public static void copy()throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);
        String data;
        while ((data=br.readLine())!=null) {
            System.out.println(data);   //向标准输出流写数据
            System.err.println(data);   //向标准错误输出流写数据
        }
    }

    public static void main(String args[])throws IOException {
        InputStream standardIn = System.in;
        PrintStream standardOut = System.out;
        PrintStream standardErr = System.err;

        InputStream in = new BufferedInputStream(new FileInputStream("/Users/kongshuaiying/Desktop/test.txt"));
        PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream("/Users/kongshuaiying/Desktop/out.txt")));
        PrintStream err = new PrintStream(new BufferedOutputStream(new FileOutputStream("/Users/kongshuaiying/Desktop/err.txt")));
        redirect(in,out,err);   //把标准I/O重定向到文件
        copy(); //把test.txt文件中的数据复制到。。。

        //对于用户创建的流，不再使用它们时，应该关闭它们
        in.close();
        out.close();
        err.close();

        redirect(standardIn,standardOut,standardErr);   //使标准I/O采用默认的流
        copy(); //把从键盘输入的数据输出到控制台
    }
}
