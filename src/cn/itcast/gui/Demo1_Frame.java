package cn.itcast.gui;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Demo1_Frame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Frame f = new Frame("我的第一个窗口");
		f.setSize(400, 600);							//设置大小
		f.setLocation(500, 50);							//设置位置
		f.setIconImage(Toolkit.getDefaultToolkit().createImage("qq.png"));//设置图标
		
		Button b1 = new Button("按钮1");
		f.add(b1);										//将按钮添加到窗体中
		f.setLayout(new FlowLayout());					//将布局管理器设置为流式布局
		//f.addWindowListener(new MyWindowAdapter());
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		b1.addMouseListener(new MouseAdapter() {		//添加鼠标监听
			@Override
			public void mouseReleased(MouseEvent e) {
				System.exit(0);
			}
		});
		
		b1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				//System.out.println(e.getKeyCode());
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {	//键盘事件
					System.exit(0);
				}
				
			}
		});
		
		Button b2 = new Button("按钮2");
		f.add(b2);
		
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		f.setVisible(true);								//设置窗体显示
	}

}

/*class MyWindowListener implements WindowListener {

	@Override
	public void windowOpened(WindowEvent e) {
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}
	
}
*/

class MyWindowAdapter extends WindowAdapter {
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}