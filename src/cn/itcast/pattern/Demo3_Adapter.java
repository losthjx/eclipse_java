package cn.itcast.pattern;

public class Demo3_Adapter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}

interface 和尚 {
	public void 打坐();
	public void 念经();
	public void 撞钟();
	public void 练武();
}

abstract class 天罡星 implements 和尚 {

	@Override
	public void 打坐() {
	}

	@Override
	public void 念经() {
	}

	@Override
	public void 撞钟() {
	}

	@Override
	public void 练武() {
	}
	
}

class 花和尚 extends 天罡星 {
	public void 练武() {
		System.out.println("倒拔垂杨柳");
		System.out.println("拳打镇关西");
		System.out.println("大闹野猪林");
		System.out.println("...");
	}
}
