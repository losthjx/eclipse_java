package cn.itcast.pattern;

public class Demo3_Adapter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}

interface ���� {
	public void ����();
	public void �();
	public void ײ��();
	public void ����();
}

abstract class ����� implements ���� {

	@Override
	public void ����() {
	}

	@Override
	public void �() {
	}

	@Override
	public void ײ��() {
	}

	@Override
	public void ����() {
	}
	
}

class ������ extends ����� {
	public void ����() {
		System.out.println("���δ�����");
		System.out.println("ȭ�������");
		System.out.println("����Ұ����");
		System.out.println("...");
	}
}
