package cn.itcast.thread;

public class Demo1_Yield {

	/**
	 * @param args
	 * yield()方法让出CPU,礼让线程
	 */
	public static void main(String[] args) {
		new MyThread().start();
		new MyThread().start();
	}

}

class MyThread extends Thread {
	public void run() {
		for(int i = 1; i <= 1000; i++) {
			if(i % 10 == 0) {
				Thread.yield();
			}
			
			System.out.println(getName() + "...." + i);
		}
	}
}
