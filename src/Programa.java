/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ads
 */
import java.util.ArrayList;

public class Programa {
    
        int itemCount;
        ArrayList buffer;
        Semaphore semaphore;
    
        Programa () {
            itemCount = 0;
            buffer = new ArrayList();
            this.semaphore = new Semaphore();
        }
    
        int compartilhada;
    
        public static void main(String[] args) {
               Programa t = new Programa();
               t.run();
        } 
        
        public void run() {
            Consumer c = new Consumer(this,this.semaphore);
            Producer p = new Producer(this,this.semaphore);
            c.start();
            p.start();
            Consumer c1 = new Consumer(this,this.semaphore);
            Producer p1 = new Producer(this,this.semaphore);
            c1.start();
            p1.start();
        }
    
    
}
