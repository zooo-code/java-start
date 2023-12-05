import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class JavaFile {
    public static void main(String[] args) throws IOException {
        System.out.println("args = " + Arrays.toString(args));
        File file = new File("C:\\Users\\kyj20\\Desktop\\study\\studyjava\\studyjava\\src\\main\\java\\collections\\JavaCollections.java");
        String name = file.getName();
        int pos = name.lastIndexOf(".");
        System.out.println("name = " + name);
        System.out.println("name.substring(0,pos) = " + name.substring(0,pos));
        System.out.println("file.getPath() = " + file.getPath());
        File newFile = new File(".\\src\\main\\java\\", "javaFile/NewJavaFile.java");
        boolean newFile1 = newFile.createNewFile();
    }
}
