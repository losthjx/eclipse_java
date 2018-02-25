package cn.itcast.thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Demo5_Timer {

	/**
	 * @param args
	 * Timer��һ����ʱ����,��ָ��ʱ��ִ��ָ������
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		Timer t = new Timer();													//������ʱ������
		//t.schedule(new MyTimerTask(), new Date(115, 3, 9, 10, 41 , 00)); 		//����ָ��ʱ��,ִ��ָ������
		t.schedule(new MyTimerTask(), new Date(115, 3, 9, 10, 42 , 30),3000);
		while(true) {
			Thread.sleep(1000);
			System.out.println(new Date());
		}
	}

}


class MyTimerTask extends TimerTask {

	@Override
	public void run() {
		System.out.println("�𴲱�Ӣ�ﵥ��");
	}
	
}

