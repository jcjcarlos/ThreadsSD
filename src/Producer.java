/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ads
 */
public class Producer extends Thread {
    
        Programa a;

        int contador;
        Semaphore semaphore;
        public Producer(Programa x,Semaphore semaphore) {

               a = x;
               contador =0;
        }

        public void run() {

               try {
                   while (true) {
                       while (a.itemCount == 10)
                           sleep(100);
                       contador ++;
                       a.buffer.add(contador);
                       a.itemCount++;
                       this.semaphore.down();
                       System.out.println("produtor: producing item "+contador);
                       for (int i =0;i<10000;i++);
                   }

               }

               catch(InterruptedException e) {

                       e.printStackTrace(); 

               }

        }
    
    
}
