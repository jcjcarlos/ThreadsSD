/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ads
 */
public class Consumer extends Thread {
    
        Programa a;
        Semaphore semaphore;

        public Consumer(Programa x, Semaphore semaphore) {

               a = x;
               this.semaphore = semaphore;
        }

        public void run() {

               try {
                   while (true) {
                       while (a.itemCount == 0)
                           sleep(100);
                       this.semaphore.up();
                       int item;
                       item = (Integer) a.buffer.get(0);
                       a.buffer.remove(0);
                       a.itemCount--;
                       System.out.println("consumer: consuming item "+item);
                       for (int i =0;i<10000;i++);
                   }

               }

               catch(InterruptedException e) {

                       e.printStackTrace(); 

               }

        }
    
    
}
