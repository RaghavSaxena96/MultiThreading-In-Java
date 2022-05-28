import java.util.concurrent.*;

class Shared {
    static int count = 0;
}
class Schedule implements Runnable {
    
    Semaphore sem;
    
    Schedule(Semaphore se){
        sem=se;
    }
    
    @Override
    public void run(){
        try{
            sem.acquire();
            
            for(int i=1;i<=5;i++){
                System.out.println(i+"  "+Thread.currentThread().getId());
                Thread.sleep(1000);
            }
             
            sem.release();
        
            }catch(Exception e){
                
            }
        }
}
class HelloWorld {
    public static void main(String[] args) {
        Semaphore sem = new Semaphore(1);
        
        Thread t1=new Thread(new Schedule(sem));
        Thread t2=new Thread(new Schedule(sem));
        
        t1.start();
        t2.start();
        
        try{
            t1.join();
            t2.join();
        }catch(Exception e){
            
        }
    }
}
