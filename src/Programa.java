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
	Semaphore mutex;
	Semaphore items;
	Semaphore spaces;

	Programa() {
		itemCount = 0;
		buffer = new ArrayList();
		this.mutex = new Semaphore(1);
		this.items = new Semaphore(0);
		this.spaces = new Semaphore(100);

	}

	int compartilhada;

	public static void main(String[] args) {
		Programa t = new Programa();
		t.run();
	}

	public void run() {
		Consumer c = new Consumer(this, "0");
		Consumer c1 = new Consumer(this, "1");
		Consumer c2 = new Consumer(this, "2");
		Producer p = new Producer(this, "0");
		// Producer p1 = new Producer(this,"1");
		c.start();
		c1.start();
		c2.start();
		p.start();
		// p1.start();

	}

}
