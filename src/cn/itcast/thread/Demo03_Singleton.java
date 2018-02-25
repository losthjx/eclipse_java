package cn.itcast.thread;

public class Demo03_Singleton {

	/**
	 * @param args
	 * �������ģʽ
	 */
	public static void main(String[] args) {
		/*Singleton s1 = Singleton.s;
		Singleton.s = null;
		Singleton s2 = Singleton.s;
		
		System.out.println(s1 == s2);*/
		
		/*Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		
		System.out.println(s1 == s2);*/
		
		Singleton s1 = Singleton.s;
		Singleton s2 = Singleton.s;
		
		System.out.println(s1 == s2);
	}

}
//����ʽ
/*class Singleton {
	private Singleton() {}								//˽�й��췽��,���������ഴ���������
	
	private static Singleton s = new Singleton();		//�����������
	
	public static Singleton getInstance() {				//�����ṩ�����ķ��ʷ���,���ر������
		return s;
	}
}*/

//����ʽ,�������ӳټ���
/*class Singleton {
	private Singleton() {}								//˽�й��췽��,���������ഴ���������
	
	private static Singleton s;
	
	public static Singleton getInstance() {				//�����ṩ�����ķ��ʷ���,���ر������
		if (s == null)
			//�߳�1,�߳�2
			s = new Singleton();
		return s;
	}
}*/

/*����ʽ������ʽ������
 * ���ǵ��߳�
 * ����ʽ�ǿռ任ʱ��
 * ����ʽ��ʱ�任�ռ�
 * ���Ƕ��߳�
 * ����ʽ��û�а�ȫ������
 * ����ʽ�ǿ��ܻ���ְ�ȫ����,�ֿ��ܴ����������
 */

class Singleton {
	private Singleton() {}								//˽�й��췽��,���������ഴ���������
	
	public final static Singleton s = new Singleton();	//�������๫���ľ�̬��final���εĶ���
	
}