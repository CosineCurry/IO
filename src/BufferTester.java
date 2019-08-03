//例程18-19 BufferTester.java
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class BufferTester {
    public static void main(String args[])throws IOException {
        final int BSIZE = 1024;
        //把test.txt文件中的数据复制到out.txt
        FileChannel in = new FileInputStream("/Users/kongshuaiying/Desktop/test.txt").getChannel();
        FileChannel out = new FileOutputStream("/Users/kongshuaiying/Desktop/out.txt").getChannel();

        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        while (in.read(buff)!=-1) {
            buff.flip();    //将极限设置为位置，再把位置设置为0
            out.write(buff);
            buff.clear();   //把极限设置为容量，再把位置设为0
        }
        in.close();
        out.close();
    }
}
