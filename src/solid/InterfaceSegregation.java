package solid;

public class InterfaceSegregation {
}
// 인터페이스 분리 원칙을 지키는 예제
interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

class ISPSuperWorker implements Workable, Eatable {
    @Override
    public void work() {
        System.out.println("Working very hard");
    }

    @Override
    public void eat() {
        System.out.println("Eating in lunch break");
    }
}

class ISPNormalWorker implements Workable {
    @Override
    public void work() {
        System.out.println("Working");
    }
}

// 클라이언트 코드
class ISPManager {
    private Workable worker;

    public void setWorker(Workable worker) {
        this.worker = worker;
    }

    public void manage() {
        worker.work();
    }
}