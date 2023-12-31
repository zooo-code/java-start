package deginepattern;

/**
 * "상위 클래스의 견본 메서드에서 하위 클래스가 오버라이딩한 메서드를 호출하는 패턴"
 * 탬플릿 메서드 패턴(Template Method Pattern)은 알고리즘의 뼈대를 정의하고,
 * 알고리즘의 일부 단계를 서브클래스에서 구현하도록 하는 디자인 패턴입니다.
 * 아래는 Java에서 간단한 탬플릿 메서드 패턴을 구현한 예시 코드입니다.
 *
 * 이 예시에서는 커피를 만드는 과정을 탬플릿 메서드 패턴으로 구현해보겠습니다
 */
public class TemplateMethodPattern {

    public static void main(String[] args) {
        CoffeeTemplate coffee = new CoffeeWithHook();
        coffee.makeCoffee();
    }
}
// 커피 만들기를 나타내는 추상 클래스 (탬플릿)
abstract class CoffeeTemplate {
    // 탬플릿 메서드: 커피 만들기의 일반적인 과정을 정의(템플릿을 제공하고 강제 구현 해야하는 메서드를 둔다)
    public final void makeCoffee() {
        boilWater();
        brewCoffeeGrounds();
        pourInCup();
        addCondiments();
        System.out.println("Coffee is ready!");
    }

    // 서브클래스에서 구현해야 하는 단계들
    protected abstract void boilWater();
    protected abstract void brewCoffeeGrounds();
    protected abstract void pourInCup();

    // 서브클래스에서 선택적으로 오버라이딩할 수 있는 단계
    protected void addCondiments() {
        // 기본 구현: 추가재료가 없음
    }
}

// 커피 만들기를 구체적으로 구현하는 서브클래스
class CoffeeWithHook extends CoffeeTemplate {
    @Override
    protected void boilWater() {
        System.out.println("Boiling water");
    }

    @Override
    protected void brewCoffeeGrounds() {
        System.out.println("Brewing coffee grounds");
    }

    @Override
    protected void pourInCup() {
        System.out.println("Pouring coffee into cup");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding sugar and milk");
    }
}
