package cn.itcast.bean2;

public class DogFactory implements Factory {

	@Override
	public Animal createAnimal() {

		return new Dog();
	}

}
