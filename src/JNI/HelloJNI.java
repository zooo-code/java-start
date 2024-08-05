package JNI;

public class HelloJNI {
    native void printHello();

    static {
        System.loadLibrary("hellojni");
    }
}