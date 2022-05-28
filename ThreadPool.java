
/*
In case of thread Pool , pool size is decided by the task you need to perform. 
If your task is CPU intensive you need to have Pool size is same as 
number of CPU core on your system. 
*/

/*
If your task is IO intensive then when those IO calls are made for either 
database or HTTP calls your threads are in waiting state in this scenario you
can have a pool size as large one
*/
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
        ExecutorService executor = Executors.newFixedThreadPool(10);
        
        for(int i=1;i<=100;i++){
            executor.execute(new Schedule());
        }
    }
}