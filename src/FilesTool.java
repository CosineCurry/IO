import java.io.IOException;
import java.nio.file.*;

public class FilesTool {
    public void copyFile(String fromDir,String toDir,String file)throws IOException {
        Path pathFrom = Paths.get(fromDir,new String[] {file});
        Path pathTo = Paths.get(toDir,new String[] {file});
        //调用文件复制方法，如果目标文件已经存在就将其覆盖
        Files.copy(pathFrom,pathTo, StandardCopyOption.REPLACE_EXISTING);
    }

    public void moveFile(String fromDir,String toDir,String file)throws IOException {
        Path pathFrom = Paths.get(fromDir,new String[] {file});
        Path pathTo = Paths.get(toDir,new String[] {file});
        //文件的大小bytes
        System.out.println(Files.size(pathFrom));
        //调用文件移动方法，如果目标文件已经存在就将其覆盖
        Files.move(pathFrom,pathTo, StandardCopyOption.REPLACE_EXISTING);
    }

    public void createAndShowDir(String dir)throws IOException {
        Path path = Paths.get(dir);
        //创建文件夹
        if (Files.notExists(path)) {
            Files.createDirectories(path);
            System.out.println("create dir");
        }else {
            System.out.println("dir exists");
        }

        //遍历文件夹下面的文件
        DirectoryStream<Path> paths = Files.newDirectoryStream(path);
        for (Path p:paths)
            System.out.println(p.getFileName());

        System.out.println("以下是以java、txt、bat结尾的文件");
        //创建一个带有过滤器的目录流，过滤条件为文件名以java、txt、bat结尾
        DirectoryStream<Path> pathsStream = Files.newDirectoryStream(path,".{java,txt,bat}");
        for (Path p:pathsStream)
            System.out.println(p.getFileName());
    }

    public static void main(String[] args)throws IOException {
        FilesTool tool = new FilesTool();

        //把D：目录下的hello.txt文件复制到C：目录下
        tool.copyFile("D:\\","C:\\","test.txt");

        //遍历循环C：//dollapp目录下的内容
        tool.createAndShowDir("C:\\dollapp");
    }
}
