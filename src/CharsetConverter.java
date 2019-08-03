//例程18-20 CharsetConverter.java
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

public class CharsetConverter {
    public static void main(String args[])throws IOException {
        final int BSIZE = 1024;
        //代码1
        ByteBuffer bb = ByteBuffer.wrap("你好".getBytes("UTF-8"));
        CharBuffer cb = bb.asCharBuffer();
        System.out.println(cb); //打印？？

        //代码2
        bb = ByteBuffer.wrap("你好".getBytes("UTF-16BE"));
        cb = bb.asCharBuffer();
        System.out.println(cb); //打印"你好"

        //代码3
        bb = ByteBuffer.wrap("你好".getBytes("UTF-8"));
        Charset cs = Charset.forName("UTF-8");
        cb = cs.decode(bb);
        System.out.println(cb); //打印"你好"

        //代码4
        cs = Charset.forName("GBK");
        bb = cs.encode("你好");
        cb = cs.decode(bb);
        for (int i=0;i<cb.limit();i++)  //打印"你好"
            System.out.println(cb.get());
    }
}
