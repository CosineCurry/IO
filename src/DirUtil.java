//例程18-30 DirUtil.java
import java.io.File;
import java.util.Date;

public class DirUtil {
    public static void main(String args[])throws Exception {
        //mkdir只能创建一层目录，而mkdirs可以创建多层
        File dir1 = new File("/Users/kongshuaiying/Desktop/dir1");
        if(!dir1.exists()) dir1.mkdir();

        File dir2 = new File(dir1,"dir2");
        if(!dir2.exists()) dir2.mkdirs();

        File dir4 = new File(dir1,"dir3/dir4");
        if(!dir4.exists()) dir4.mkdirs();

        File file = new File(dir2,"test.txt");
        if(!file.exists()) file.createNewFile();

        listDir(dir1);

        //deleteDir(dir1);
    }

    /** 查看目录信息 */
    public static void listDir(File dir) {
        File[] lists = dir.listFiles();

        //打印当前目录下包含的所有子目录和文件的名字
        String info = "目录： "+dir.getName()+"(";
        for (int i=0;i<lists.length;i++)
            info += lists[i].getName()+" ";
        info += ")";
        System.out.println(info);

        //打印当前目录下包含的所有子目录和文件的详细信息
        for (int i=0;i<lists.length;i++) {
            File f = lists[i];
            if (f.isFile())
                System.out.println("文件："+f.getName()
                +"canRead: "+f.canRead()
                +"lastModified: "+new Date(f.lastModified()));
            else //如果为目录，就递归调用listDir()方法
                listDir(f);
        }
    }

    /** 删除目录或文件，如果参数file代表目录，会删除当前目录及目录下的所有内容 */
    public static void deleteDir(File file) {
        if (file.isFile()) {    //如果file代表文件，就删除该文件
            file.delete();
            return;
        }

        //如果file代表目录，先删除目录下的所有子目录和文件、
        File[] lists= file.listFiles();
        for (int i=0;i<lists.length;i++)
            deleteDir(lists[i]);    //递归删除当前目录下的所有子目录和文件

        file.delete();  //最后删除当前目录
    }
}
