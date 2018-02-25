package cn.itcast.thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Demo5_Timer {

	/**
	 * @param args
	 * Timer是一个计时器类,在指定时间执行指定任务
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		Timer t = new Timer();													//创建计时器对象
		//t.schedule(new MyTimerTask(), new Date(115, 3, 9, 10, 41 , 00)); 		//安排指定时间,执行指定任务
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
		System.out.println("起床背英语单词");
	}
	
}

