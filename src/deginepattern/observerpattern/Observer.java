package deginepattern.observerpattern;

public class Observer implements IObserver {

    String name;

    public Observer(String name) {
        this.name = name;
    }


    @Override
    public void notifyObservers() {
        System.out.println("Observer notify observer" +name);
    }
}
