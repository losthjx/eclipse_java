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
//�ȴ����ѻ���
/*
 * ��ͬ�����������������˭,�����ĸ�����������wait
 * Ϊʲôwait������notify������Ҫ������Object
 * ���еĶ�����Object���������,�����еĶ��󶼿��Ե���������
 * 
 * sleep������wait����������
 * 1,sleep�������봫�����,��������ʱ��,��ʱ�䵽��,���û����Զ�����
 * 	wait�������Ǳ��봫�����,���û�в���,����wait�͵ȴ�,����������,�Ȳ�����ʱ�䵽��ȴ�
 * 2,sleep������ͬ���в��ͷ���
 *   wait������ͬ�����ͷ���
 */
class Printer {
	private int flag = 1;								//������
	private Object obj = new Object();
	public void print1() throws InterruptedException {
		synchronized(this) {
			while(flag != 1) {								//�����ǲ�Ϊ1�͵ȴ�
				this.wait();
			}
			System.out.print("��");
			System.out.print("��");
			System.out.print("��");
			System.out.print("��");
			System.out.print("Ա");
			System.out.print("\r\n");
			flag = 2;
			this.notifyAll();								//���������һ���߳�
		}
	}
	
	public void print2() throws InterruptedException {
		synchronized(this) {
			while(flag != 2) {								//�����ǲ�Ϊ2�͵ȴ�
				this.wait();							//�߳�2�ȴ�
			}
			System.out.print("��");
			System.out.print("��");
			System.out.print("��");
			System.out.print("��");
			System.out.print("\r\n");
			flag = 3;
			this.notifyAll();								//���������һ���߳�
		}
	}
	
	public void print3() throws InterruptedException {
		synchronized(this) {
			while(flag != 3) {								//�����ǲ�Ϊ2�͵ȴ�
				this.wait();							//�߳�3�ȴ�
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
			this.notifyAll();								//�������еȴ����߳�				
		}
	}
}