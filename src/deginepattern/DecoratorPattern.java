package deginepattern;

/**
 * "메서드 호출의 반환 값에 변화를 주기 위해 중간에 장식자를 두는 패턴"
 * 데코레이터 패턴(Decorator Pattern)은 객체에 동적으로 새로운 책임을 추가할 수 있는 패턴입니다.
 * 기본 객체에 기능을 추가할 때, 상속보다 유연한 방법을 제공합니다.
 * 아래는 Java에서 데코레이터 패턴을 구현한 예시 코드입니다.
 *
 * 데코레이터 패턴은 프록시 패턴과 구현 방법이 같지만, 프록시 패턴은 클라이언트가 최종적으로 돌려 받는 반환 값을 조작하지 않고
 * 그대로 전달하는 반면 데코레이터 패턴은 클라이언트가 받는 반환 값에 장식을 덧입한다.
 *
 * 프록시 패턴은 제어의 프름을 변경하거나 별도의 로직 처리를 목적으로 한다. 클라이언트가 반환값을 특별한 경우가 아니면 변경하지 않는다.
 *
 * 데코레이터 패턴은 클라이언트가 받는 반환 값에 장식을 더한다.
 *
 * 데코레이터 패턴을 설명하기 위해, 간단한 커피 예제를 사용해보겠습니다.
 * Coffee 인터페이스를 정의하고, 이를 구현하는 기본 커피 클래스 SimpleCoffee가 있습니다.
 * 그리고 이 커피에 여러 추가 재료(데코레이터)를 추가하는 예시를 보여줍니다.
 */
public class DecoratorPattern {

    public static void main(String[] args) {
        // 기본 커피
        Coffee simpleCoffee = new SimpleCoffee();
        System.out.println("Cost: " + simpleCoffee.getCost() + "; Description: " + simpleCoffee.getDescription());

        // 우유 추가
        Coffee milkCoffee = new MilkDecorator(simpleCoffee);
        System.out.println("Cost: " + milkCoffee.getCost() + "; Description: " + milkCoffee.getDescription());

        // 설탕 추가
        Coffee sweetCoffee = new SugarDecorator(milkCoffee);
        System.out.println("Cost: " + sweetCoffee.getCost() + "; Description: " + sweetCoffee.getDescription());
    }
}

// 커피 인터페이스
interface Coffee {
    String getDescription();
    double getCost();
}

// 기본 커피 클래스
class SimpleCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Simple Coffee";
    }

    @Override
    public double getCost() {
        return 5.0;
    }
}

// 데코레이터 추상 클래스
abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee decoratedCoffee) {
        this.decoratedCoffee = decoratedCoffee;
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription();
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost();
    }
}

// 추가 재료를 나타내는 데코레이터 클래스
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Milk";
    }

    @Override
    public double getCost() {
        return super.getCost() + 2.0;
    }
}

class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Sugar";
    }

    @Override
    public double getCost() {
        return super.getCost() + 1.0;
    }
}
