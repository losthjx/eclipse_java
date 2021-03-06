package cn.itcast.thread;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
	
	private int num;
	public MyCallable(int num) {
		this.num = num;
	}
	@Override
	public Integer call() throws Exception {
		int sum = 0;
		for(int i = 1; i <= num; i++) {
			sum = sum + i;
		}
		return sum;
	}

}
