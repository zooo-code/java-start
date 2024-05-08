package deginepattern.observerpattern;

public class ObserverPattern {


    public static void main(String[] args) {


        IObserver observer1 = new Observer("observer1");
        IObserver observer2 = new Observer("observer2");
        IObserver observer3 = new Observer("observer3");
        IObserver observer4 = new Observer("observer4");


        ISubject subject = new Subject();
        subject.addObserver(observer1);
        subject.addObserver(observer2);
        subject.addObserver(observer3);
        subject.addObserver(observer4);

        subject.notifyObservers();
        System.out.println("remove observer3");
        subject.removeObserver(observer3);

        subject.notifyObservers();



    }
}
