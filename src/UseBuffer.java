//例程18-3 UseBuffer.java
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class UseBuffer {
    public static void main(String args[])throws IOException {
        final int SIZE = 1024;
        FileInputStream in = new FileInputStream("/Users/kongshuaiying/Desktop/test.txt");
        FileOutputStream out = new FileOutputStream("/Users/kongshuaiying/Desktop/out.txt");

        byte[] buff = new byte[SIZE];   //创建字节数组缓冲区

        int len = in.read(buff);    //把test.txt文件中的数据读入到buff中
        while (len!=-1) {
            out.write(buff,0,len);  //把buff中的数据写到out.txt文件中
            len=in.read(buff);
        }
        in.close();
        out.close();
    }
}
