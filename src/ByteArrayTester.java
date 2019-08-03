//例程18-1 ByteArrayTester.java
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ByteArrayTester {
    public static void main(String args[])throws IOException {
        byte[] buff = new byte[] {2,15,67,-1,-9,9};
        ByteArrayInputStream in = new ByteArrayInputStream(buff,1,4);
        int data = in.read();
        while (data!=-1) {
            System.out.println(data+" ");
            data = in.read();
        }
        in.close(); //ByteArrayInputStream的close()方法实际上不执行任何操作
    }
}
