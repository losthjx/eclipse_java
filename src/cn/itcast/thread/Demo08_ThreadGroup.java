package cn.itcast.thread;

public class Demo08_ThreadGroup {

	/**
	 * @param args
	 * public final ThreadGroup getThreadGroup()//ͨ���̶߳����ȡ�������ڵ���
	 * public final String getName()//ͨ���߳�������ȡ���������
	 * 
	 * Ĭ�������߳���
	 */
	public static void main(String[] args) {
		//demo1();
		ThreadGroup tg = new ThreadGroup("����һ���߳���");
		Thread t1 = new Thread(tg, new MyRunnable(), "����");		//��ָ���̼߳���ָ�����߳���
		Thread t2 = new Thread(tg, new MyRunnable(), "����");		//��ָ���̼߳���ָ�����߳���
		
		//tg.setDaemon(true);
		System.out.println(tg.getName());
	}

	public static void demo1() {
		MyRunnable mr = new MyRunnable();
		Thread t1 = new Thread(mr, "����");
		Thread t2 = new Thread(mr, "����");
		ThreadGroup tg1 = t1.getThreadGroup();
		ThreadGroup tg2 = t2.getThreadGroup();

		System.out.println(tg1.getName());
		System.out.println(tg2.getName());
	}

}
