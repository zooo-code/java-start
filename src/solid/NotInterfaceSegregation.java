package solid;

public class NotInterfaceSegregation {
}
// 인터페이스 분리 원칙을 위반하는 예제
interface Worker {
    void work();

    void eat();
}

class SuperWorker implements Worker {
    @Override
    public void work() {
        System.out.println("Working very hard");
    }

    @Override
    public void eat() {
        System.out.println("Eating in lunch break");
    }
}

class NormalWorker implements Worker {
    @Override
    public void work() {
        System.out.println("Working");
    }

    @Override
    public void eat() {
        System.out.println("Eating in lunch break");
    }
}

// 클라이언트 코드
class Manager {
    private Worker worker;

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public void manage() {
        worker.work();
    }
}