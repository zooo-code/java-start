package deginepattern;
/**
 * "오버라이드된 메서드가 객체를 반환하는 패턴이다"
 * 팩토리 메소드 패턴(Factory Method Pattern)은 객체 생성을 캡슐화하는 디자인 패턴 중 하나로,
 * 객체를 생성하는 인터페이스를 정의하고,
 * 서브클래스에서 어떤 클래스의 인스턴스를 생성할지를 결정하게 합니다.
 * 아래는 Java에서 간단한 팩토리 메소드 패턴을 구현한 예시 코드입니다.
 *
 * 이 예시에서는 동물을 생성하는 동물 팩토리를 구현해보겠습니다.
 */
public class FactoryMethodPattern {
    public static void main(String[] args) {
        // Dog를 생성하는 팩토리를 이용하여 Dog 인스턴스 생성
        AnimalFactory dogFactory = new DogFactory();
        Animal dog = dogFactory.createAnimal();
        dog.makeSound();

        // Cat을 생성하는 팩토리를 이용하여 Cat 인스턴스 생성
        AnimalFactory catFactory = new CatFactory();
        Animal cat = catFactory.createAnimal();
        cat.makeSound();
    }
}
// 동물을 나타내는 인터페이스
interface Animal {
    void makeSound();
}

// 팩토리 메소드를 가지는 동물 생성을 담당하는 인터페이스
interface AnimalFactory {
    Animal createAnimal();
}

// 각각의 동물을 구현하는 클래스들
class Dog implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }
}

class Cat implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }
}

// 동물을 생성하는 팩토리 메소드를 구현하는 클래스들
class DogFactory implements AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Dog();
    }
}

class CatFactory implements AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Cat();
    }
}