package _Setting;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import aframe.aframe;
import main.main_gameland;

@SuppressWarnings("serial")
public class Setting extends aframe {

	int sm = 1;
	JPanel jp;
	ImageIcon ic = new ImageIcon(new ImageIcon("switch.jpg").getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH));
	Image im = ic.getImage();

	public Setting() {
		// TODO Auto-generated constructor stub
		fs("세팅");

		add(jp = new JPanel());
		jp.setBackground(Color.white);
		jp.setPreferredSize(new Dimension(300, 300));
		tm.start();

		sh();
	}

	Color col = Color.red;
	String s = "초기화 하는중", ss = ".";
	Timer tm = new Timer(5, new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (sm < 360) {
				sm++;
			} else {
				tm.stop();
				s = "완료!";
				dispose();
				new main_gameland();
//				new main();
			}
			float n2 = (float) sm / 360 * 255;
			col = new Color(0, 0, (int) n2);
			ss = "";
			for (int i = 0; i < sm % 10; i++) {
				ss = ss + "■";
			}
			try {
				if (sm == 50) {

					tm.setDelay(40);
					s = "기반 구축중";
				} else if (sm == 150) {
					tm.setDelay(10);
					s = "기반 다지는중";
				} else if (sm == 200) {
					tm.setDelay(60);
					s = "설치중";
				} else if (sm == 280) {
					tm.setDelay(20);
					s = "리소스 불러오는중";
				} else if (sm == 330) {
					tm.setDelay(3);
					s = "마무리하는중";
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
			jp.removeAll();
			float n = (float) sm / 360 * 100;
			jp.add(ap = new JPanel() {
				protected void paintComponent(java.awt.Graphics g) {
					g.setColor(col);
					g.fillArc(20, 20, 260, 260, 90, -sm);
					g.setColor(Color.white);
					g.fillOval(50, 50, 200, 200);
					Graphics2D g2 = (Graphics2D) g;
					g2.setColor(Color.black);
					g2.setFont(new Font("맑은고딕", Font.BOLD, 13));
					g2.drawString(Math.round(n) + " % (" + s + ")", 100, 150);
					g.setColor(new Color(sm % 10 * 20, sm % 10 * 20, sm % 10 * 20));
					g.drawString(ss, 100, 170);
				};
			});

			ap.setBackground(Color.white);
			ap.setPreferredSize(new Dimension(300, 300));

			repaint();
			revalidate();
		}
	});

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Setting();
	}

}
