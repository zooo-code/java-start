package deginepattern.observerpattern;

import java.util.ArrayList;
import java.util.List;

public class Subject implements ISubject{

    private List<IObserver> observers = new ArrayList<IObserver>();

    @Override
    public void addObserver(IObserver observer) {

        observers.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {

        for(IObserver observer :observers){
            observer.notifyObservers();

        }


    }
}
