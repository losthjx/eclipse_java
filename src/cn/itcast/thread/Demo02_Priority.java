package cn.itcast.thread;

public class Demo02_Priority {

	/**
	 * @param args
	 * setPriority()�����߳����ȼ�
	 * ��߼�����10Thread.MAX_PRIORITY
	 * ��ͼ�����1Thread.MIN_PRIORITY
	 */
	public static void main(String[] args) {
		Thread t1 = new Thread() {
			public void run() {
				for(int i = 0; i < 1000; i++) {
					System.out.println(getName() + "...aaaaaaaaaaaaa");
				}
			}
		};
		
		Thread t2 = new Thread() {
			public void run() {
				for(int i = 0; i < 1000; i++) {
					System.out.println(getName() + "...bb");
				}
			}
		};
		
		t1.setPriority(Thread.MIN_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY);
		
		t1.start();
		t2.start();
	}

}
