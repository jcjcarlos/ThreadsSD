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
        String id;
        int contador;
        Semaphore semaphore;
        public Producer(Programa x, String id) {

               a = x;
               contador =0;
               this.id = id;
        }

        public void run() {

               while (true) {
			       //while (a.itemCount == 10)
			       //    sleep(100);
			       contador ++;
			       a.spaces.down();
			       a.mutex.down();
			       a.buffer.add(contador);
			       a.mutex.up();
			       a.itemCount++;
			       a.items.up();
			 
			       System.out.println("produtor "+id+": producing item "+ contador);
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
