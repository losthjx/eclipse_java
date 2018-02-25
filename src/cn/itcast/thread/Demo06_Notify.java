package cn.itcast.thread;

public class Demo06_Notify {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final Printer p = new Printer();
		
		new Thread() {
			public void run() {
				while(true) {
					try {
						p.print1();
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
				}
			}
		}.start();
		
		new Thread() {
			public void run() {
				while(true) {
					try {
						p.print2();
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
				}
			}
		}.start();
		
		new Thread() {
			public void run() {
				while(true) {
					try {
						p.print3();
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
				}
			}
		}.start();
	}

}
//等待唤醒机制
/*
 * 在同步代码块中锁对象是谁,就用哪个对象来调用wait
 * 为什么wait方法和notify方法需要定义在Object
 * 所有的对象都是Object的子类对象,而所有的对象都可以当作锁对象
 * 
 * sleep方法和wait方法的区别
 * 1,sleep方法必须传入参数,参数就是时间,当时间到了,不用唤醒自动醒来
 * 	wait方法不是必须传入参数,如果没有参数,遇到wait就等待,如果传入参数,等参数的时间到后等待
 * 2,sleep方法在同步中不释放锁
 *   wait方法在同步中释放锁
 */
class Printer {
	private int flag = 1;								//定义标记
	private Object obj = new Object();
	public void print1() throws InterruptedException {
		synchronized(this) {
			while(flag != 1) {								//如果标记不为1就等待
				this.wait();
			}
			System.out.print("黑");
			System.out.print("马");
			System.out.print("程");
			System.out.print("序");
			System.out.print("员");
			System.out.print("\r\n");
			flag = 2;
			this.notifyAll();								//随机唤醒另一条线程
		}
	}
	
	public void print2() throws InterruptedException {
		synchronized(this) {
			while(flag != 2) {								//如果标记不为2就等待
				this.wait();							//线程2等待
			}
			System.out.print("传");
			System.out.print("智");
			System.out.print("播");
			System.out.print("客");
			System.out.print("\r\n");
			flag = 3;
			this.notifyAll();								//随机唤醒另一条线程
		}
	}
	
	public void print3() throws InterruptedException {
		synchronized(this) {
			while(flag != 3) {								//如果标记不为2就等待
				this.wait();							//线程3等待
			}
			System.out.print("i");
			System.out.print("t");
			System.out.print("c");
			System.out.print("a");
			System.out.print("s");
			System.out.print("t");
			System.out.print("\r\n");
			flag = 1;
			//this.notify();								//随机唤醒另一条线程
			this.notifyAll();								//唤醒所有等待的线程				
		}
	}
}