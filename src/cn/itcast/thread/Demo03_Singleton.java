package cn.itcast.thread;

public class Demo03_Singleton {

	/**
	 * @param args
	 * 单例设计模式
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
//饿汉式
/*class Singleton {
	private Singleton() {}								//私有构造方法,不让其他类创建本类对象
	
	private static Singleton s = new Singleton();		//创建本类对象
	
	public static Singleton getInstance() {				//对外提供公共的访问方法,返回本类对象
		return s;
	}
}*/

//懒汉式,单例的延迟加载
/*class Singleton {
	private Singleton() {}								//私有构造方法,不让其他类创建本类对象
	
	private static Singleton s;
	
	public static Singleton getInstance() {				//对外提供公共的访问方法,返回本类对象
		if (s == null)
			//线程1,线程2
			s = new Singleton();
		return s;
	}
}*/

/*饿汉式和懒汉式的区别
 * 都是单线程
 * 饿汉式是空间换时间
 * 懒汉式是时间换空间
 * 都是多线程
 * 饿汉式是没有安全隐患的
 * 懒汉式是可能会出现安全隐患,又可能创建多个对象
 */

class Singleton {
	private Singleton() {}								//私有构造方法,不让其他类创建本类对象
	
	public final static Singleton s = new Singleton();	//创建本类公共的静态的final修饰的对象
	
}