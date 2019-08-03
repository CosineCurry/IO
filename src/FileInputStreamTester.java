//例程18-2 FileInputStreamTester.java
import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamTester {
    public static void main(String args[])throws IOException {
        FileInputStream in = new FileInputStream("/Users/kongshuaiying/Desktop/test.txt");
        int data;
        while ((data=in.read())!=-1)
            System.out.println(data+" ");
        in.close();
    }
}
