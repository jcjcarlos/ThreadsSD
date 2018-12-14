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
        String id;

        public Consumer(Programa x, String id) {

               a = x;
               this.id = id;
        }

        public void run() {

               while (true) {
			       //while (a.itemCount == 0)
			       //    sleep(100);
			       a.items.down();
			       a.mutex.down();
			       int item;
			       item = (Integer) a.buffer.get(0);
			       a.buffer.remove(0);
			       a.mutex.up();
			       a.itemCount--;
			       a.spaces.up();
			       System.out.println("consumer "+id+": consuming item "+ item);
			       try {
					sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			       //for (int i =0;i<10000;i++);
			   }

        }
    
    
}
