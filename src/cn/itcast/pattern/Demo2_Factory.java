package cn.itcast.pattern;

import cn.itcast.bean2.Animal;
import cn.itcast.bean2.DogFactory;

public class Demo2_Factory {

	/**
	 * A:��������ģʽ����
	 * ��������ģʽ�г��󹤳��ฺ���崴������Ľӿڣ��������Ĵ��������ɼ̳г��󹤳��ľ�����ʵ�֡�
	 * B:�ŵ�
	 * �ͻ��˲���Ҫ�ڸ������Ĵ������Ӷ���ȷ�˸������ְ��������µĶ������ӣ�ֻ��Ҫ����һ���������;���Ĺ����༴�ɣ���Ӱ�����еĴ��룬����ά�����ף���ǿ��ϵͳ����չ��
	 * C:ȱ��
	 * ��Ҫ����ı�д���룬�����˹�����
	 */
	public static void main(String[] args) {
		DogFactory df = new DogFactory();
		
		Animal a = df.createAnimal();
		a.eat();
	}

}
