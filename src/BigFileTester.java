//例程18-24 BigFileTester.java
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class BigFileTester {
    public static void main(String args[])throws IOException {
        int capacity = 0x8000000;//128M
        MappedByteBuffer mb = new RandomAccessFile("/Users/kongshuaiying/Desktop/test.txt","rw")
                .getChannel().map(FileChannel.MapMode.READ_WRITE,0,capacity);
        mb.put("你好啊".getBytes("GBK"));  //向文件写入采用GBK编码的字符串"你好啊"
        mb.flip();
        System.out.println(Charset.forName("GBK").decode(mb));
    }
}
