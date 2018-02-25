package cn.itcast.thread;

import java.io.IOException;

public class Demo4_Runtime {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Runtime r = Runtime.getRuntime();				//获取到Runtime这个类实例对象
		//r.exec("shutdown -s -t 300");					//设置关机
		r.exec("shutdown -a");
	}

}
