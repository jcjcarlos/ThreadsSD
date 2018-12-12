public class MultiThread  {

        MultiThread () {
            compartilhada = 1;
            semaphore = new Semaphore(1);
        }
    
        int compartilhada;
        Semaphore semaphore;
    
        public static void main(String[] args) {
               MultiThread t = new MultiThread();
               t.run();
        }

        public void run() {
               UmaThread t1,t2,t3;
               
               //t1 = new UmaThread("Primeira", this, (int)(Math.random()*8000));
               t1 = new UmaThread("Primeira", this);
               
               //t2 = new UmaThread("Segunda", this, (int)(Math.random()*8000));
               t2 = new UmaThread("Segunda", this);
               
               //t3 = new UmaThread("Terceira", this, (int)(Math.random()*8000));
               t3 = new UmaThread("Terceira", this);
               
               t1.start();

               t2.start();

               t3.start();
        }
}

