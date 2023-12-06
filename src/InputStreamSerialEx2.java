import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;


public class InputStreamSerialEx2 {

    public static void main(String[] args) {
        try {
            String fileName = "UserInfo.ser";
            FileInputStream fis = new FileInputStream(fileName);
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream in = new ObjectInputStream(bis);

            JavaSerializable.UserInfo u1 = (JavaSerializable.UserInfo) in.readObject();
            JavaSerializable.UserInfo u2 = (JavaSerializable.UserInfo) in.readObject();
            ArrayList list = (ArrayList) in.readObject();

            System.out.println("u1 = " + u1);
            System.out.println("u2 = " + u2);
            System.out.println("list = " + list);
            in.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
