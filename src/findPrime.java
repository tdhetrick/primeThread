import java.util.ArrayList;

public class findPrime implements Runnable {
    private Thread t;
    int start = 0;
    int end = 0;
    ArrayList<Integer> primes = new ArrayList<Integer>();

    findPrime( ArrayList<Integer> primes,int start, int end) {
        this.primes = primes;
        if (start % 2 == 0){
            this.start = start+1;
        }else{
            this.start = start;
        }

        this.end = end;
        System.out.println("Creating Thread");
    }

    public void run() {
        //System.out.println("Running thread");
        for (int i = start;i<= end; i = i + 2){
            boolean flag = false;
            for (int j = 3; j <= i / 2; j=j+2) {

                if (i % j == 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag){
                this.primes.add(i);
                //System.out.println(i + " "+this.start+ " "+this.end+ " -> " +this.getState().toString());
            }

        }

        System.out.println("Thread  exiting.");
    }

    public void start () {

        //System.out.println("Starting Thread" );
        if (t == null) {
            t = new Thread (this);
            t.start ();
        }
    }

    public Thread.State getState() {
        return t.getState();
    }
}
