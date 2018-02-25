package cn.itcast.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Demo07_ReentrantLock {

	/**
	 * 1.5�汾�������Ի�����
	 * 1.ͬ��
	 * ʹ��ReentrantLock���lock()��unlock()��������ͬ��
	 * 2.ͨ��
	 * ʹ��ReentrantLock���newCondition()�������Ի�ȡCondition����
	 * ��Ҫ�ȴ���ʱ��ʹ��Condition��await()����, ���ѵ�ʱ����signal()����
	 * ��ͬ���߳�ʹ�ò�ͬ��Condition, �����������ֻ��ѵ�ʱ�����ĸ��߳���
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
	private ReentrantLock r = new ReentrantLock();		//��������������
	private Condition c1 = r.newCondition();			//����������
	private Condition c2 = r.newCondition();
	private Condition c3 = r.newCondition();
	private int flag = 1;								//������
	//private Object obj = new Object();
	public void print1() throws InterruptedException {
		r.lock();
			if(flag != 1) {								//�����ǲ�Ϊ1�͵ȴ�
				c1.await();
			}
			System.out.print("��");
			System.out.print("��");
			System.out.print("��");
			System.out.print("��");
			System.out.print("Ա");
			System.out.print("\r\n");
			flag = 2;
			c2.signal();
		r.unlock();
	}
	
	public void print2() throws InterruptedException {
		r.lock();
			if(flag != 2) {								//�����ǲ�Ϊ2�͵ȴ�
				c2.await();							//�߳�2�ȴ�
			}
			System.out.print("��");
			System.out.print("��");
			System.out.print("��");
			System.out.print("��");
			System.out.print("\r\n");
			flag = 3;
			c3.signal();						//���������һ���߳�
		r.unlock();
	}
	
	public void print3() throws InterruptedException {
		r.lock();
			if(flag != 3) {								//�����ǲ�Ϊ2�͵ȴ�
				c3.await();						//�߳�3�ȴ�
			}
			System.out.print("i");
			System.out.print("t");
			System.out.print("c");
			System.out.print("a");
			System.out.print("s");
			System.out.print("t");
			System.out.print("\r\n");
			flag = 1;
			//this.notify();								//���������һ���߳�
			c1.signal();							//�������еȴ����߳�				
		r.unlock();
	}
}