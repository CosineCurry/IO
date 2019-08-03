//例程18-25 LockTester.java
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;

public class LockTester {
    public static void main(String args[]) throws IOException {
        FileOutputStream fos = new FileOutputStream("/Users/kongshuaiying/Desktop/test.txt");
        FileLock fl = fos.getChannel().tryLock();
        if (fl!=null) {
            System.out.println("Locked File");
            System.out.println(fl.isShared());
            try {
                Thread.sleep(60000);    //锁定文件60秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            fl.release();
            System.out.println("Released Lock");
        }
    }
}
