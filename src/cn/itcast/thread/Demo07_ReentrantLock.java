package cn.itcast.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Demo07_ReentrantLock {

	/**
	 * 1.5版本的新特性互斥锁
	 * 1.同步
	 * 使用ReentrantLock类的lock()和unlock()方法进行同步
	 * 2.通信
	 * 使用ReentrantLock类的newCondition()方法可以获取Condition对象
	 * 需要等待的时候使用Condition的await()方法, 唤醒的时候用signal()方法
	 * 不同的线程使用不同的Condition, 这样就能区分唤醒的时候找哪个线程了
	 */
	public static void main(String[] args) {
		final Printer2 p = new Printer2();
		
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

class Printer2 {
	private ReentrantLock r = new ReentrantLock();		//创建互斥锁对象
	private Condition c1 = r.newCondition();			//创建监视器
	private Condition c2 = r.newCondition();
	private Condition c3 = r.newCondition();
	private int flag = 1;								//定义标记
	//private Object obj = new Object();
	public void print1() throws InterruptedException {
		r.lock();
			if(flag != 1) {								//如果标记不为1就等待
				c1.await();
			}
			System.out.print("黑");
			System.out.print("马");
			System.out.print("程");
			System.out.print("序");
			System.out.print("员");
			System.out.print("\r\n");
			flag = 2;
			c2.signal();
		r.unlock();
	}
	
	public void print2() throws InterruptedException {
		r.lock();
			if(flag != 2) {								//如果标记不为2就等待
				c2.await();							//线程2等待
			}
			System.out.print("传");
			System.out.print("智");
			System.out.print("播");
			System.out.print("客");
			System.out.print("\r\n");
			flag = 3;
			c3.signal();						//随机唤醒另一条线程
		r.unlock();
	}
	
	public void print3() throws InterruptedException {
		r.lock();
			if(flag != 3) {								//如果标记不为2就等待
				c3.await();						//线程3等待
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
			c1.signal();							//唤醒所有等待的线程				
		r.unlock();
	}
}