import java.util.ArrayList;

import static java.lang.System.currentTimeMillis;
import static java.lang.Thread.State.TERMINATED;

public class main {

    public static void main(String[] args) {
        long st =  currentTimeMillis();
        //ArrayList<Integer> primes = new ArrayList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        findPrime[] thd = new findPrime[30];
        boolean finished = false;
        int tc = 15;
        int max = 8000000;
        int start = 2;
        for (int i = 0 ; i < tc; i++){
            int end = start + max/tc;
            System.out.println("Starting "+ i + " start:" +start+ " end:"+end );
            res.add(i,new ArrayList<>());
            thd[i] = new findPrime( res.get(i), start, end);
            thd[i].start();
            start = start + max/tc ;
        }

        System.out.println(thd.length);

        while(!finished){
            finished = true;
            for (int t = 0 ; t < thd.length; t++){
                if (thd[t] != null) {
                    if (thd[t].getState() != TERMINATED) {
                        finished = false;
                    }
                    //System.out.println(t + " -> " +thd[t].getState().toString());
                }
            }
            //System.out.println("Thread Check");
        }



        //for (Integer i : primes){
        //   System.out.println(i);
        //}

        int total =0;
        for (int p = 0;p< res.size();p++){
            total = res.get(p).size() + total;
            System.out.println("Thread"+ p +" Primes: "+ res.get(p).size());
        }
        System.out.println("Num Primes: "+ total);
        System.out.println("Time elapsed: "+ ((currentTimeMillis() - st)/1000));

    }

}
