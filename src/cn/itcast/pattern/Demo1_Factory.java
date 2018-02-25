package cn.itcast.pattern;

import cn.itcast.bean.Animal;
import cn.itcast.bean.AnimalFactory;
import cn.itcast.bean.Cat;
import cn.itcast.bean.Dog;

public class Demo1_Factory {

	/**
	 * A:�򵥹���ģʽ����
	 * �ֽо�̬��������ģʽ��������һ������Ĺ����ฺ�𴴽�һЩ���ʵ��
	 * B:�ŵ�
		* �ͻ��˲���Ҫ�ڸ������Ĵ������Ӷ���ȷ�˸������ְ��
	 * C:ȱ��
		* �����̬�����ฺ�����ж���Ĵ�����������µĶ������ӣ�����ĳЩ����Ĵ�����ʽ��ͬ������Ҫ���ϵ��޸Ĺ����࣬�����ں��ڵ�ά��
	 * D:������ʾ
	 * ��������ࣺpublic abstract Animal { public abstract void eat(); }
	 * ���幷�ࣺpublic class Dog extends Animal {}
	 * ����è�ࣺpublic class Cat extends Animal {}
	 * ��ʼ���ڲ�������ÿ������������Լ��������󣬵��ǣ���������Ĺ�������Ƚ��鷳������Ҫ����ר����������飬���Ծ�֪����һ��ר�ŵ�������������
	 */
	public static void main(String[] args) {
		//Animal a = new Cat();
		//Cat c = new Cat();
		
		/*Dog d = AnimalFactory.createDog();					//��ȡ������
		Cat c = AnimalFactory.createCat();
		
		d.eat();
		c.eat();*/
		
		Animal a1 = AnimalFactory.createAnimal("dog");
		a1.eat();
		
		Animal a2 = AnimalFactory.createAnimal("cat");
		a2.eat();
		
		Animal a3 = AnimalFactory.createAnimal("pig");
		if(a3 != null) {
			a3.eat();
		}else {
			System.out.println("û���������");
		}
		
	}

}
