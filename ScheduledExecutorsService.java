import java.util.concurrent.*;
import java.util.*;
import java.io.*;

class Schedule implements Runnable {
    
    synchronized void logging(){
            
            try{
                System.out.println("Thread is " + Thread.currentThread().getId());
                Thread.sleep(1000);
            }catch(Exception e){
                
            }finally {
                System.out.println(Thread.currentThread().getId() + " Out of Sleep");
            }
    }
    
    @Override 
    public void run(){
        logging();
    }
}

class Solution {
    public static void main(String[] args){
        // ExecutorService executor = Executors.newCachedThreadPool();
        
        ScheduledExecutorService sch = Executors.newScheduledThreadPool(10);
        
        for(int i=1;i<=100;i++){
            sch.schedule(new Schedule(),1, TimeUnit.SECONDS);
        }
    }
}
