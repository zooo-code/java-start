package sync;

public class Contribution {
    private int amount = 0;

    public synchronized void donate(){
        synchronized (this){
            amount++;
        }
    }


    public int getTotal(){
        return amount;
    }
}
