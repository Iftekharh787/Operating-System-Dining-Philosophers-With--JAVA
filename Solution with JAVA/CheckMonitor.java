   package  Test;

public class CheckMonitor {

    public synchronized void take(int i) throws InterruptedException{
    	Philosopher.numberofState[i] = Philosopher.hungry;
        test(i);
        if (Philosopher.numberofState[i]!=Philosopher.eat){
            System.out.printf("Philosopher:%d is waiting\n",i+1);
            wait();
        }
    }
    public synchronized void put(int i){
    	Philosopher.numberofState[i] = Philosopher.think;
        test((i+5-1)%5);
        test((i+1)%5);
    }
    private synchronized void test(int i){
        if (Philosopher.numberofState[i] == Philosopher.hungry&&Philosopher.numberofState[(i+5-1)%5]!=Philosopher.eat&&Philosopher.numberofState[(i+1)%5]!=Philosopher.eat){
        	Philosopher.numberofState[i] = Philosopher.eat;
            notifyAll();
        }
    }
}