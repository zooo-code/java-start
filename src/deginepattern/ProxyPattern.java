package deginepattern;

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