package Test;

 

public class Philosopher implements Runnable{
	
	public static final int think=0;
  public static final int hungry=1;
  public static final int eat=2 ;
  
  public static int [] numberofState = new int[5];
	    
	    int i;
	    CheckMonitor monitor;
	    public Philosopher(int i,CheckMonitor monitor){
	    	this.i = i;
	        this.monitor = monitor;
	        
	    }

	    @Override
	    public void run() {
	        while(true){
	            try{
	                System.out.printf("Philosopher %d is thinking\n",i+1);
	                monitor.take(i);
	                System.out.printf("Philosopher %d is eating\n",i+1);
	                monitor.put(i);
	            }
	            catch(InterruptedException e){
	            	
	            }
	        }
	    }
	    
	    public static void main(String[] args) {
	        // TODO code application logic here
	        CheckMonitor ourmonitor = new CheckMonitor();
	        Philosopher [] p = new Philosopher[5];
	        for(int i = 0;i < 5;i++){
	            numberofState[i] = think;
	            p[i] = new Philosopher(i,ourmonitor);
	            new Thread(p[i],"Philosopher:"+(i+1)).start();
	        }
	    }
	    
}
