package deginepattern;

/**
 * "호출당하는 쪽의 메서드를 호출하는 쪽의 코드에 대응하도록 중간에 변환기를 통해 호출하는 패턴"
 *
 * 어댑터 디자인 패턴은 서로 다른 두 인터페이스 간의 호환성을 제공하기 위한 패턴입니다.
 * 여기에는 클래스 어댑터 패턴과 객체 어댑터 패턴이 있습니다.
 * 아래에는 객체 어댑터 패턴의 간단한 Java 코드 예시를 제시해보겠습니다.
 *
 * 예를 들어, 기존에 이미 정의된 OldSystem 클래스가 있고,
 * 새로운 시스템에서는 NewSystem 인터페이스를 사용해야 할 때,
 * 어댑터 패턴을 사용하여 두 시스템을 연결할 수 있습니다.
 */
public class AdapterPattern {
    public static void main(String[] args) {
        // 기존 시스템 사용
        OldSystem oldSystem = new OldSystem();
        oldSystem.doSomethingOld();
        // 어댑터를 사용하여 새로운 시스템과 연결
        NewSystem newSystem = new Adapter(oldSystem);
        newSystem.doSomethingNew();
    }
}

//기존 시스템의 클래스
class OldSystem{
    public void doSomethingOld(){
        System.out.println("올드 시스템을 시작합니다.");
    }
}
//새로운 시스템의 인터페이스
interface NewSystem{
    void doSomethingNew();
}

/**
 * 이 예시에서 Adapter 클래스는 NewSystem 인터페이스를 구현하고
 * 기존의 OldSystem 객체를 내부에 갖고 있습니다.
 * Adapter 클래스의 doSomethingNew 메서드에서는 내부의 OldSystem 객체의 doSomethingOld 메서드를 호출하여
 * 새로운 시스템의 인터페이스에 맞추어 동작하도록 만들어진 것을 볼 수 있습니다.
 */
//어댑터 클래스
class Adapter implements NewSystem{
    private OldSystem oldSystem;

    public Adapter(OldSystem oldSystem) {
        this.oldSystem = oldSystem;
    }

    @Override
    public void doSomethingNew() {
        // 기존 시스템의 메서드를 새로운 시스템의 메서드로 변환
        oldSystem.doSomethingOld();
    }
}
