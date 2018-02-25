package cn.itcast.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo09_Executors {

	/**
	 * JDK5新增了一个Executors工厂类来产生线程池，有如下几个方法
		* public static ExecutorService newFixedThreadPool(int nThreads)
		* public static ExecutorService newSingleThreadExecutor()
		* 这些方法的返回值是ExecutorService对象，该对象表示一个线程池，可以执行Runnable对象或者Callable对象代表的线程。它提供了如下方法
		* Future<?> submit(Runnable task)
		* <T> Future<T> submit(Callable<T> task)
	* 使用步骤：
		* 创建线程池对象
		* 创建Runnable实例
		* 提交Runnable实例
		* 关闭线程池
	 */
	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(2);		//创建线程池,可以放两条线程
		MyRunnable mr1 = new MyRunnable();							//创建Runnable的子类对象
		MyRunnable mr2 = new MyRunnable();
		
		pool.submit(mr1);											//放在线程池并提交
		pool.submit(mr2);
		
		pool.shutdown();											//关掉线程池,不接受新任务
	}

}
