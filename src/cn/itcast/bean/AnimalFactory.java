package cn.itcast.bean;

public class AnimalFactory {
	private AnimalFactory(){}					//���������ഴ���������
	//����һ��������
	/*public static Dog createDog() {
		return new Dog();
	}
	
	//����һ��è����
	public static Cat createCat() {
		return new Cat();
	}*/
	
	//�Ľ�
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
