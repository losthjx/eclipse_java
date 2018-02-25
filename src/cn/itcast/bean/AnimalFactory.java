package cn.itcast.bean;

public class AnimalFactory {
	private AnimalFactory(){}					//不让其他类创建本类对象
	//创建一个狗对象
	/*public static Dog createDog() {
		return new Dog();
	}
	
	//创建一个猫对象
	public static Cat createCat() {
		return new Cat();
	}*/
	
	//改进
	public static Animal createAnimal(String name) {
		if(name.equals("dog")) {
			return new Dog();
		}else if(name.equals("cat")) {
			return new Cat();
		}else {
			return null;
		}
	}
}
