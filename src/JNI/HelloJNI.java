package JNI;

public class HelloJNI {

    // 네이티브 메소드 선언
    public native String sayHello();

    // 네이티브 라이브러리 로드
    static {
        System.loadLibrary("hello");
    }

    public static void main(String[] args) {
        HelloJNI helloJNI = new HelloJNI();
        String message = helloJNI.sayHello(); // 네이티브 메소드 호출
        System.out.println(message); // 네이티브 메소드 결과 출력
    }
}
