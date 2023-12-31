package solid.liskov;

/**
 * 리스코프 치환 원칙(Liskov Substitution Principle, LSP)은 객체 지향 프로그래밍에서 상속 관계에 있는 클래스들 간에
 * 서브타입(하위 타입) 관계를 유지하면서도 부모 클래스의 인스턴스를 대체하여 사용할 수 있어야 한다는 원칙입니다.
 * 즉, 자식 클래스는 부모 클래스의 기능을 사용할 수 있어야 하며,
 * 자식 클래스에서는 부모 클래스의 기능을 변경하지 않고 확장할 수 있어야 합니다.
 */
public class NotLiskovSubstitution {
    public static void main(String[] args) {
        Bird ostrich = new Ostrich();
        ostrich.fly();  // 이 부분에서 오류 발생 가능
    }

}
class Bird {
    public void fly() {
        System.out.println("Flying");
    }
}

class Ostrich extends Bird {
    // 타조는 날지 못하므로 fly 메서드를 오버라이딩하지 않음
}

