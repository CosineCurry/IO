//例程18-6 FormatDataIO.java
import java.io.*;

public class FormatDataIO {
    public static void main(String args[])throws IOException {
        FileOutputStream out1 = new FileOutputStream("/Users/kongshuaiying/Desktop/tester.txt");
        BufferedOutputStream out2 = new BufferedOutputStream(out1); //装饰文件输出流
        DataOutputStream out = new DataOutputStream(out2);  //装饰带缓冲输出流
        out.writeByte(-12);
        out.writeLong(12);
        out.writeChar('1');
        out.writeUTF("好");
        out.close();

        InputStream in1 = new FileInputStream("/Users/kongshuaiying/Desktop/tester.txt");
        BufferedInputStream in2 = new BufferedInputStream(in1); //装饰文件输入流
        DataInputStream in = new DataInputStream(in2);  //装饰带缓冲输入流
        System.out.println(in.readByte()+" ");
        System.out.println(in.readLong()+" ");
        System.out.println(in.readChar()+" ");
        System.out.println(in.readUTF()+" ");
        in.close();
    }
}
