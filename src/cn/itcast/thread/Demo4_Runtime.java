package cn.itcast.thread;

import java.io.IOException;

public class Demo4_Runtime {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Runtime r = Runtime.getRuntime();				//��ȡ��Runtime�����ʵ������
		//r.exec("shutdown -s -t 300");					//���ùػ�
		r.exec("shutdown -a");
	}

}
