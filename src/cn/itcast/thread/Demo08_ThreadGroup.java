package cn.itcast.thread;

public class Demo08_ThreadGroup {

	/**
	 * @param args
	 * public final ThreadGroup getThreadGroup()//通过线程对象获取他所属于的组
	 * public final String getName()//通过线程组对象获取他组的名字
	 * 
	 * 默认是主线程组
	 */
	public static void main(String[] args) {
		//demo1();
		ThreadGroup tg = new ThreadGroup("我是一个线程组");
		Thread t1 = new Thread(tg, new MyRunnable(), "张三");		//将指定线程加入指定的线程组
		Thread t2 = new Thread(tg, new MyRunnable(), "李四");		//将指定线程加入指定的线程组
		
		//tg.setDaemon(true);
		System.out.println(tg.getName());
	}

	public static void demo1() {
		MyRunnable mr = new MyRunnable();
		Thread t1 = new Thread(mr, "张三");
		Thread t2 = new Thread(mr, "李四");
		ThreadGroup tg1 = t1.getThreadGroup();
		ThreadGroup tg2 = t2.getThreadGroup();

		System.out.println(tg1.getName());
		System.out.println(tg2.getName());
	}

}
