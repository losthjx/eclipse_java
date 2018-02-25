package cn.itcast.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Demo10_Callable {

	/**
	 * @param args
	 * @throws ExecutionException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService pool = Executors.newFixedThreadPool(2);		//�����̳߳�,���Է������߳�
		MyCallable mc1 = new MyCallable(100);
		MyCallable mc2 = new MyCallable(200);
		
		Future<Integer> f1 = pool.submit(mc1);											//�����̳߳ز��ύ
		Future<Integer> f2 = pool.submit(mc2);
		
		Integer i1 = f1.get();										//��ȡ���
		Integer i2 = f2.get();
		
		System.out.println(i1);
		System.out.println(i2);
		pool.shutdown();											//�ص��̳߳�,������������
	}

}
