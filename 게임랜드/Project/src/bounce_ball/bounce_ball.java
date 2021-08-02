package bounce_ball;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.BitSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import aframe.aframe;
import bounce_ball_base.bounce_ball_star_reserdata;
import bounce_ball_base.map;
import main.logs;
import main.main_gameland;

@SuppressWarnings("serial")
public class bounce_ball extends aframe {

	private int h = 300, jp = 0, x = 50, inc[][] = new int[5][2];
	private double g = 1;

	JPanel bounce;
	Thread th = new Thread(this);
	boolean run = true, eatstar = false;

	private static int stage = 1;
	private static long smilli = 0, emilli = 0;
	private static int wall[][] = new int[35][20];
	private static int star[][] = new int[35][20];

	public static void main(String[] args) {
		new bounce_ball();
	}

	public bounce_ball() {
		// TODO Auto-generated constructor stub
		fs("바운스볼");

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosed(e);
				run = false;
				stage = 1;
				h = 300;
				jp = 0;
				x = 50;
				main_gameland.appendToPane(main_gameland.log, "바운스볼 게임 종료!\n", new Color(139, 65, 237));
				main_gameland.ch = 0;
			}
		});

		stage = 1;
		h = 300;
		jp = 0;
		x = 50;
		map.stage.clear();
		bounce_ball_base.star.star.clear();

		for (int i = 0; i < bounce_ball_base.star.stage1.length; i++) {
			for (int j = 0; j < bounce_ball_base.star.stage1[i].length; j++) {
				bounce_ball_base.star.stage1[i][j] = bounce_ball_star_reserdata.stage1[i][j];
			}
		}

		for (int i = 0; i < bounce_ball_base.star.stage1.length; i++) {
			for (int j = 0; j < bounce_ball_base.star.stage1[i].length; j++) {
				bounce_ball_base.star.stage2[i][j] = bounce_ball_star_reserdata.stage2[i][j];
			}
		}

		for (int i = 0; i < bounce_ball_base.star.stage1.length; i++) {
			for (int j = 0; j < bounce_ball_base.star.stage1[i].length; j++) {
				bounce_ball_base.star.stage3[i][j] = bounce_ball_star_reserdata.stage3[i][j];
			}
		}

		for (int i = 0; i < bounce_ball_base.star.stage1.length; i++) {
			for (int j = 0; j < bounce_ball_base.star.stage1[i].length; j++) {
				bounce_ball_base.star.stage4[i][j] = bounce_ball_star_reserdata.stage4[i][j];
			}
		}

		for (int i = 0; i < bounce_ball_base.star.stage1.length; i++) {
			for (int j = 0; j < bounce_ball_base.star.stage1[i].length; j++) {
				bounce_ball_base.star.stage5[i][j] = bounce_ball_star_reserdata.stage5[i][j];
			}
		}

		for (int i = 0; i < bounce_ball_base.star.stage1.length; i++) {
			for (int j = 0; j < bounce_ball_base.star.stage1[i].length; j++) {
				bounce_ball_base.star.stage6[i][j] = bounce_ball_star_reserdata.stage6[i][j];
			}
		}

		// 맵 저장
		map.stage.add(map.stage6);
		map.stage.add(map.stage5);
		map.stage.add(map.stage4);
		map.stage.add(map.stage3);
		map.stage.add(map.stage2);
		map.stage.add(map.stage1);

		// 별 저장
		bounce_ball_base.star.star.add(bounce_ball_base.star.stage6);
		bounce_ball_base.star.star.add(bounce_ball_base.star.stage5);
		bounce_ball_base.star.star.add(bounce_ball_base.star.stage4);
		bounce_ball_base.star.star.add(bounce_ball_base.star.stage3);
		bounce_ball_base.star.star.add(bounce_ball_base.star.stage2);
		bounce_ball_base.star.star.add(bounce_ball_base.star.stage1);

		// 불러오기
		wall = map.stage.pop();

		star = bounce_ball_base.star.star.pop();

		// 앱0
		cp.add(ap = new JPanel(new BorderLayout()) {
			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				super.paintComponent(g);
				// 벽
				for (int i = 0; i < wall.length; i++) {
					for (int j = 0; j < wall[i].length; j++) {
						if (wall[i][j] == 1) {
							g.setColor(Color.red);
							g.fillRect(i * 30, j * 30, 30, 30);
						}
					}
				}

				// 별
				for (int i = 0; i < wall.length; i++) {
					for (int j = 0; j < wall[i].length; j++) {
						if (star[i][j] == 1) {
							ImageIcon ic = new ImageIcon("image/star.png");
							Image im = ic.getImage();
							g.drawImage(im, i * 30, j * 30, 30, 30, this);
						}
					}
				}

			}
		});

		ap.setBackground(Color.white);
		size(cp, 1050, 600);
		size(ap, 1050, 600);

		ap.add(bounce = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				super.paintComponent(g);
//				for (int i = 0; i < inc.length; i++) {
//					g.setColor(new Color(220 - i * 50, 220 - i * 50, 220 - i * 50));
//					g.fillOval(inc[i][0], inc[i][1], 30, 30);
//				}
				g.setColor(Color.yellow);
				g.fillOval(x, h, 30, 30);
				g.setColor(Color.black);
				Graphics2D g2 = (Graphics2D) g;
				g2.setStroke(new BasicStroke(2));
				g2.drawOval(x, h, 30, 30);
//				if (eatstar) {
//					for (int i = 0; i < 5; i++) {
//						g2.fillOval(x+i*10, h+i*10, 20, 20);
//					}
//					eatstar = false;
//				}
			}
		});

		bounce.setOpaque(false);
		size(bounce, 1050, 600);

		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				try {
					if (e.getKeyCode() == 37) {
						for (int i = 0; i < 4; i++) {
							if (wall[(x - 1) / 30][h / 30] == 1 || wall[(x - 1) / 30][(h + 30) / 30] == 1) {// 왼쪽
								return;
							}
							x--;
							getstar(x, h);
							repaint();
							revalidate();
						}
					}
					if (e.getKeyCode() == 39) {
						for (int i = 0; i < 4; i++) {
							if (wall[(x + 31) / 30][h / 30] == 1 || wall[(x + 31) / 30][(h + 30) / 30] == 1) {// 오른쪽
								return;
							}
							x++;
							getstar(x, h);
							repaint();
							revalidate();
						}
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				BitSet b = new BitSet();
				b.set(e.getKeyCode());

			}
		});

		th.start();
		smilli = System.currentTimeMillis();
		this.setResizable(false);
		sh();
	}

	public void getstar(int x, int h) {
		try {
			if (x < 0 || h < 0 || (h + 30) < 0 || (h + 30) / 30 > 19 || (x + 30) / 30 > 34) {

			} else {
				if (star[x / 30][h / 30] == 1) {
					star[x / 30][h / 30] = 0;
					eatstar = true;
					return;
				}
				if (star[x / 30][(h + 30) / 30] == 1) {
					star[x / 30][(h + 30) / 30] = 0;
					eatstar = true;
					return;
				}
				if (star[(x + 30) / 30][h / 30] == 1) {
					star[(x + 30) / 30][h / 30] = 0;
					eatstar = true;
					return;
				}
				if (star[(x + 30) / 30][(h + 30) / 30] == 1) {
					star[(x + 30) / 30][(h + 30) / 30] = 0;
					eatstar = true;
					return;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@SuppressWarnings("static-access")
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while (run) {
			try {
//				System.out.println(jp + "/" + g + "/" + h);
//				for (int i = 1; i < inc.length; i++) {
//					for (int j = 0; j < 2; j++) {
//						inc[i - 1][j] = inc[i][j];
//					}
//				}
				inc[4][0] = x;
				inc[4][1] = h;
				if (jp == 0) {
					g = g + 0.098;
					h = (int) (h + g);
				} else {
					g = g - 0.098;
					h = (int) (h - g);
				}

				if (x < 0 || h < 0 || (h + 30) < 0 || (h + 30) / 30 > 19 || (x + 30) / 30 > 34) {

				} else {
					getstar(x, h);
				}
				th.sleep(10);

				int x2 = x + 29;

				if (x <= 0 || h < -30 || (h + 30) / 30 > 19 || (x + 29) / 30 > 34) {
					// 맵 밖
//					System.err.println(h + "/" + x);
					if (h >= 600) {
						// 죽음
						gameEnd();
					}
				} else {
//					System.out.println(h + "/" + x);
					if (wall[(x + 1) / 30][(h + 30) / 30] == 1 || wall[x2 / 30][(h + 30) / 30] == 1) {// 바닥
						jp = 1;
						g = 5;

					} else if (g <= 0) {
						jp = 0;
					}

					if (wall[(x + 1) / 30][h / 30] == 1 || wall[x2 / 30][h / 30] == 1) {// 천장
						jp = 0;
					}
				}

				int cnt = 0;
				for (int i = 0; i < wall.length; i++) {
					for (int j = 0; j < wall[i].length; j++) {
						if (star[i][j] == 1) {
							cnt++;
						}
					}
				}

				if (cnt == 0) {// 스테이지 클리어
					if (map.stage.size() == 0) {
						// 다깸
						stage++;
						gameEnd();
					} else {
						h = 300;
						x = 50;
						wall = map.stage.pop();
						star = bounce_ball_base.star.star.pop();
						stage++;
					}
				}

				repaint();
				revalidate();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		}
	}

	public void gameEnd() {
		emilli = System.currentTimeMillis();
		String s = JOptionPane.showInputDialog(this,
				"스테이지 : " + stage + " \n 걸린시간 : " + ss.format(emilli - smilli) + " \n이름을 입력해 주세요. :");
		logs.log = s;
		main_gameland.appendToPane(main_gameland.log,
				s + "님이 바운스볼 게임에서 \n스테이지 : " + stage + " \n걸린시간 : " + ss.format(emilli - smilli) + "을 기록 하셨습니다.\n",
				new Color(245, 128, 248));

		for (int i = 0; i < main_gameland.listBounce.length; i++) {

			if (main_gameland.listBounce[i].getText().equals((i + 1) + ". ")) {
				main_gameland.listBounce[i]
						.setText((i + 1) + ". " + stage + "/" + ss.format(emilli - smilli) + "  (" + s + ")");
				break;
			} else {
				String sss[] = main_gameland.listBounce[i].getText().split(" ");
				String st[] = sss[1].split("/");
				try {
					Date t1 = ss.parse(st[1]);
					Date t2 = ss.parse(ss.format(emilli - smilli));
					if (Integer.parseInt(st[0]) < stage) {

						String savest = main_gameland.listBounce[i].getText();
						for (int j = i; j < main_gameland.listBounce.length - 1; j++) {
							String subsavest = main_gameland.listBounce[j + 1].getText();
							main_gameland.listBounce[j + 1]
									.setText((j + 2) + "." + savest.substring(2, savest.length()));
							savest = subsavest;
						}
						main_gameland.listBounce[i]
								.setText((i + 1) + ". " + stage + "/" + ss.format(emilli - smilli) + "  (" + s + ")");
						break;
					} else if (Integer.parseInt(st[0]) == stage && t1.getTime() > t2.getTime()) {
						String savest = main_gameland.listBounce[i].getText();
						for (int j = i; j < main_gameland.listBounce.length - 1; j++) {
							String subsavest = main_gameland.listBounce[j + 1].getText();
							main_gameland.listBounce[j + 1]
									.setText((j + 2) + "." + savest.substring(2, savest.length()));
							savest = subsavest;
						}
						main_gameland.listBounce[i]
								.setText((i + 1) + ". " + stage + "/" + ss.format(emilli - smilli) + "  (" + s + ")");
						break;
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
		main_gameland.ch = 0;
		dispose();
		run = false;

	}

}
