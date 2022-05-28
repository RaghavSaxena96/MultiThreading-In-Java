class Schedule implements Runnable {
    
    @Override
    public  void run(){
         for(int i=0;i<10;i++){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}

class Solution {
    
    public static void main(String args[]){
        
        Thread t1=new Thread(new Schedule());
        Thread t2=new Thread(new Schedule());
        t1.start();
        try{
          t1.join();
        }catch(Exception e){
            
        }
        t2.start();
    }
}