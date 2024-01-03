package deginepattern;

/**
 * "클라이언트가 전략을 생성해 전략을 실행할 컨텍스트를 주입하는 패턴"
 * 클라이언트는 다양한 전략 중 하나를 선택해 생성한 후 컨텍스트에 주입한다.
 *
 * 전략 패턴(Strategy Pattern)은 동일한 문제를 해결하기 위해 여러 알고리즘이 제공될 때,
 * 각각의 알고리즘을 캡슐화하고 이들을 상호 교환 가능하게 만드는 디자인 패턴입니다.
 * 아래는 Java에서 간단한 전략 패턴을 구현한 예시 코드입니다.
 *
 * 간단한 결제 시스템을 구현해보겠습니다.
 * 여러 결제 수단이 존재하고,
 * 각 결제 수단에 따라 다른 할인 정책을 적용할 수 있도록 전략 패턴을 사용합니다.
 *
 * 전략 패턴은 디ㅣ자인 패턴의 꽃이라고 할 정도로 많은 곳에서 사용된다.
 * 그리고 혹시나 템플릿 메서드 패턴과 유사하다는 느낌이 든다면, 제대로 본 것이다.
 * 같은 문제의 해결책으로 상속을 이용하는 템플릿 메서드 패턴과 객체 주입을 통한 전략 패턴중에서 선택/적용할 수 있다.
 *
 * 단일 상속만 가능한 자바 언어에서는 상속이라는 제한이 있는 템플릿 메서드 패턴보다는 전략 패턴이 더 많이 활용된다.
 */
public class StrategyPattern {
    public static void main(String[] args) {
        // 신용카드 결제
        PaymentStrategy creditCardPayment = new CreditCardPayment();
        Order order1 = new Order(creditCardPayment);
        order1.processOrder(100);

        // 페이팔 결제
        PaymentStrategy payPalPayment = new PayPalPayment();
        Order order2 = new Order(payPalPayment);
        order2.processOrder(150);

        // 현금 결제
        PaymentStrategy cashPayment = new CashPayment();
        Order order3 = new Order(cashPayment);
        order3.processOrder(80);
        PaymentStrategy paymentStrategy = amount -> System.out.println("나는 새로운 페이먼트이다. 비용은 " + amount);

        Order order = new Order(paymentStrategy);
        order.processOrder(8000);
    }
}
// 결제 전략 인터페이스
interface PaymentStrategy {
    void pay(int amount);
}

// 신용카드 결제 전략
class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " via Credit Card");
    }
}

// 페이팔 결제 전략
class PayPalPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " via PayPal");
    }
}

// 현금 결제 전략
class CashPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " in Cash");
    }
}

// 결제 수단에 따라 할인 정책이 다른 주문 클래스
class Order {
    private PaymentStrategy paymentStrategy;

    public Order(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void processOrder(int amount) {
        // 주문 처리 로직
        System.out.println("Processing order with amount: " + amount);

        // 결제 전략에 따라 결제 수행
        paymentStrategy.pay(amount);
    }
}