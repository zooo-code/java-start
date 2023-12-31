package deginepattern;

/**
 * "제어 흐름을 조정하기 위한 목적으로 중간에 대리자를 두는 패턴"
 *
 * 프록시 패턴(Proxy Pattern)은 다른 객체에 대한 인터페이스를 제공하여 해당 객체에 대한 접근을 제어하는 패턴입니다.
 * 프록시는 대상 객체를 감싸고, 대상 객체에 대한 접근을 제어하거나 부가적인 기능을 제공합니다.
 * 아래는 간단한 Java 코드 예시입니다.
 *
 * 예를 들어, 파일을 읽고 쓰는 작업을 하는 클래스 RealFile 이 있고,
 * 이에 대한 접근을 제어하는 프록시 클래스 FileProxy 를 만들어보겠습니다.
 *
 */
public class ProxyPattern {
    public static void main(String[] args) {
        // 프록시를 사용하여 파일에 접근
        File file = new FileProxy("example.txt");
        // 파일을 표시하려는 시점에서 실제 파일을 로딩하고 표시
        file.display();
    }
}

// 실제 파일을 다루는 클래스
class RealFile implements File {
    private String filename;

    public RealFile(String filename) {
        this.filename = filename;
        loadFromFile();
    }

    private void loadFromFile() {
        System.out.println("Loading file: " + filename);
        // 파일 로딩 로직
    }

    @Override
    public void display() {
        System.out.println("Displaying file: " + filename);
        // 파일 표시 로직
    }
}

// 파일 작업에 대한 인터페이스
interface File {
    void display();
}

// 파일 접근을 제어하는 프록시 클래스
class FileProxy implements File {
    private RealFile realFile;
    private String filename;

    public FileProxy(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        // 필요할 때만 실제 파일을 생성 (지연 초기화)
        if (realFile == null) {
            realFile = new RealFile(filename);
        }
        // 실제 파일 표시
        realFile.display();
    }
}