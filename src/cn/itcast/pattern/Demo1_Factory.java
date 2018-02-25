package cn.itcast.pattern;

import cn.itcast.bean.Animal;
import cn.itcast.bean.AnimalFactory;
import cn.itcast.bean.Cat;
import cn.itcast.bean.Dog;

public class Demo1_Factory {

	/**
	 * A:简单工厂模式概述
	 * 又叫静态工厂方法模式，它定义一个具体的工厂类负责创建一些类的实例
	 * B:优点
		* 客户端不需要在负责对象的创建，从而明确了各个类的职责
	 * C:缺点
		* 这个静态工厂类负责所有对象的创建，如果有新的对象增加，或者某些对象的创建方式不同，就需要不断的修改工厂类，不利于后期的维护
	 * D:案例演示
	 * 动物抽象类：public abstract Animal { public abstract void eat(); }
	 * 具体狗类：public class Dog extends Animal {}
	 * 具体猫类：public class Cat extends Animal {}
	 * 开始，在测试类中每个具体的内容自己创建对象，但是，创建对象的工作如果比较麻烦，就需要有人专门做这个事情，所以就知道了一个专门的类来创建对象。
	 */
	public static void main(String[] args) {
		//Animal a = new Cat();
		//Cat c = new Cat();
		
		/*Dog d = AnimalFactory.createDog();					//获取狗对象
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
			System.out.println("没有这个动物");
		}
		
	}

}
