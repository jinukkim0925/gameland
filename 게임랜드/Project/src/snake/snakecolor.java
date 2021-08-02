package snake;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class snakecolor implements Runnable {

	public static Thread th;
	public static Color rainbow = null, gold = null;
	public static boolean run = true;
	public static int sleep = 5;
	
	
	public snakecolor() {
		// TODO Auto-generated constructor stub
		th = new Thread(this);
		th.start();
		tm.start();
		System.out.println("asdfsddd");
	}

//	int i = 150;
	static int i = 0;
	static boolean ch = false;
	public static Timer tm = new Timer(10, new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
//			gold = new Color(255,i,0);
//			if (ch) {
//				i--;
//			}else {
//				i++;
//			}
//			
//			if (i == 255) {
//				ch = true;
//			}else if (i == 150) {
//				ch = false;
//			}
			gold = new Color(i, i, i);
			if (ch) {
				i--;
			} else {
				i++;
			}

			if (i == 255) {
				ch = true;
			} else if (i == 0) {
				ch = false;
			}
		}
	});

	@SuppressWarnings("static-access")
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (run) {
			try {
				System.out.println("a");
				for (int i = 0; i < 256; i++) {
					rainbow = new Color(255, i, 0);
					th.sleep(sleep);
				}

				for (int i = 255; i > -1; i--) {
					rainbow = new Color(i, 255, 0);
					th.sleep(sleep);
				}

				for (int i = 0; i < 256; i++) {
					rainbow = new Color(0, 255, i);
					th.sleep(sleep);
				}

				for (int i = 255; i > -1; i--) {
					rainbow = new Color(0, i, 255);
					th.sleep(sleep);
				}

				for (int i = 0; i < 256; i++) {
					rainbow = new Color(i, 0, 255);
					th.sleep(sleep);
				}

				for (int i = 255; i > -1; i--) {
					rainbow = new Color(255, 0, i);
					th.sleep(sleep);
				}
				System.out.println("asdf");

			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}
