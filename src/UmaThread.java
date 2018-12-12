class UmaThread extends Thread {

        private int delay;
        
        MultiThread a;

        public UmaThread(String identificacao, MultiThread x, int delay) {

               super(identificacao);
               a = x;
               
               this.delay = delay;

        }
        
        public UmaThread(String identificacao, MultiThread x) {
        	super(identificacao);
        	a = x;
        	this.delay = 0;
        }

        public void run() {

               String identificacao = this.getName();

               try {

                        sleep(delay);
                        a.semaphore.down();
                        a.compartilhada = a.compartilhada + 2;
                        
               }

               catch(InterruptedException e) {

                       System.out.println("Thread:  "+ identificacao + " foi interrompida"); 

               }

               System.out.println(">>" + identificacao + " " + delay);
               System.out.println("Variavel = " + a.compartilhada + " ");
               a.semaphore.up();
               

        }

}

