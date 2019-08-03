//例程18-7 ByteArrayOutputStreamTester.java
import java.io.*;

public class ByteArrayOutputStreamTester {
    public static void main(String args[])throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        out.write("你好".getBytes("UTF-8"));  //把"你好"的UTF-8编码写到字节数组中

        byte[] buff = out.toByteArray();    //获得字节数组
        out.close();    //ByteArrayOutputStream的close()方法不执行任何操作

        ByteArrayInputStream in = new ByteArrayInputStream(buff);
        int len = in.available();
        byte[] buffIn = new byte[len];
        in.read(buffIn);    //把buff字节数组中的数据读入到buffIn中
        in.close(); //ByteArrayOutputStream的close()方法不执行任何操作

        System.out.println(new String(buffIn,"UTF-8")); //由字符编码创建字符串
    }
}
