package cn.itcast.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo09_Executors {

	/**
	 * JDK5������һ��Executors�������������̳߳أ������¼�������
		* public static ExecutorService newFixedThreadPool(int nThreads)
		* public static ExecutorService newSingleThreadExecutor()
		* ��Щ�����ķ���ֵ��ExecutorService���󣬸ö����ʾһ���̳߳أ�����ִ��Runnable�������Callable���������̡߳����ṩ�����·���
		* Future<?> submit(Runnable task)
		* <T> Future<T> submit(Callable<T> task)
	* ʹ�ò��裺
		* �����̳߳ض���
		* ����Runnableʵ��
		* �ύRunnableʵ��
		* �ر��̳߳�
	 */
	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(2);		//�����̳߳�,���Է������߳�
		MyRunnable mr1 = new MyRunnable();							//����Runnable���������
		MyRunnable mr2 = new MyRunnable();
		
		pool.submit(mr1);											//�����̳߳ز��ύ
		pool.submit(mr2);
		
		pool.shutdown();											//�ص��̳߳�,������������
	}

}
