import Thread.*;
import java.util.*;
class SleepDemo extends Thread {
    @Override
    public void run(){
        for(int i=0;i<=3;i++)
        {
            System.out.println("Runnig "+i);
            try{
                Thread.sleep(1000);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SleepDemo s=  new SleepDemo();
        s.start();
    }
}
