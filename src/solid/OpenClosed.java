package solid;

/**
 * 개방 폐쇄의 원칙(Open/Closed Principle, OCP)은 소프트웨어 설계 원칙 중 하나로,
 * 소프트웨어의 구성 요소(클래스, 모듈, 함수 등)는 확장에는 열려 있어야 하지만 수정에는 닫혀 있어야 한다는 원칙입니다.
 * 이것은 새로운 기능이나 변경 사항이 필요할 때 기존의 코드를 변경하지 않고 새로운 코드를 추가할 수 있어야 한다는 것을 의미합니다.
 *
 * OCP는 코드의 유연성과 확장성을 증가시키며,
 * 기존 코드에 대한 영향을 최소화하여 시스템의 안정성을 유지합니다.
 * 다음은 OCP를 따르는 간단한 예제 코드입니다.
 *
 * 첫 번째 코드에서는 AreaCalculator에 새로운 도형인 Circle이 추가될 때마다 AreaCalculator를 수정해야 합니다. 이는 OCP를 위반하는 것입니다.
 *
 * 두 번째 코드에서는 Shape 인터페이스를 도입하여 각 도형 클래스가 이를 구현하도록 합니다.
 * 이렇게 하면 AreaCalculator는 도형의 종류에 상관없이 다양한 도형을 처리할 수 있으며,
 * 새로운 도형이 추가되더라도 기존 코드를 수정하지 않아도 됩니다.
 * OCP를 따른 설계로써 코드의 확장성이 높아졌습니다.
 */
public class OpenClosed {

}
// 개방 폐쇄의 원칙을 따르지 않은 경우
class Rectangle {
    public double width;
    public double height;

}
// 새로운 기능이 추가될 때 코드 수정이 필요한 경우
class Circle {
    public double radius;
}
class AreaCalculator {
    public double calculateRectangleArea(Rectangle rectangle) {
        return rectangle.width * rectangle.height;
    }
    public double calculateCircleArea(Circle circle) {
        return Math.PI * circle.radius * circle.radius;
    }
}


// 개방 폐쇄의 원칙을 따른 경우
interface Shape {
    double calculateArea();
}

class RectangleOCP implements Shape {
    private double width;
    private double height;

    // 생성자, 게터, 세터 등 생략

    @Override
    public double calculateArea() {
        return width * height;
    }
}

class CircleOCP implements Shape {
    private double radius;

    // 생성자, 게터, 세터 등 생략

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class AreaCalculatorOCP {
    public double calculateArea(Shape shape) {
        return shape.calculateArea();
    }
}