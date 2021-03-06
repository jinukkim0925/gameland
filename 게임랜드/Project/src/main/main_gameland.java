package main;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

import aframe.aframe;
import bounce_ball.bounce_ball;

@SuppressWarnings("serial")
public class main_gameland extends aframe {

	JButton snake, pac_man, bounce_ball;

	public static JTextPane log;
	JPanel jp[] = new JPanel[3];
	JPanel rankPac, rankSnake, rankBounce;
	public static JLabel listPac[] = new JLabel[5], listSnake[] = new JLabel[5], listBounce[] = new JLabel[5];
	public static int ch = 0;

	public main_gameland() {
		// TODO Auto-generated constructor stub
		fs("???? ????");
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosing(e);
//				System.exit(0);
			}
		});

		cp.setLayout(new GridLayout(0, 4));
		size(cp, 1000, 600);

		for (int i = 0; i < jp.length; i++) {
			cp.add(jp[i] = new JPanel());
		}

		cp.add(jsp = new JScrollPane(log = new JTextPane()));

		cp.setBackground(Color.white);

		jp[0].add(snake = new JButton());
		jp[1].add(pac_man = new JButton());
		jp[2].add(bounce_ball = new JButton());

		jp[0].add(rankSnake = new JPanel(new GridLayout(5, 0)));
		jp[1].add(rankPac = new JPanel(new GridLayout(5, 0)));
		jp[2].add(rankBounce = new JPanel(new GridLayout(5, 0)));

		jp[0].setBackground(Color.white);
		jp[1].setBackground(Color.white);
		jp[2].setBackground(Color.white);

		rankBounce.setBackground(Color.white);
		rankPac.setBackground(Color.white);
		rankSnake.setBackground(Color.white);

		for (int i = 0; i < listBounce.length; i++) {
			rankBounce.add(listBounce[i] = new JLabel((i + 1) + ". "));
			listBounce[i].setFont(new Font("hy?߰???", Font.BOLD, 18));

			rankPac.add(listPac[i] = new JLabel((i + 1) + ". "));
			listPac[i].setFont(new Font("hy?߰???", Font.BOLD, 18));

			rankSnake.add(listSnake[i] = new JLabel((i + 1) + ". "));
			listSnake[i].setFont(new Font("hy?߰???", Font.BOLD, 18));
		}

		rankBounce.setBorder(new LineBorder(Color.black));
		rankPac.setBorder(new LineBorder(Color.black));
		rankSnake.setBorder(new LineBorder(Color.black));

		size(snake, 250, 300);
		size(pac_man, 250, 300);
		size(bounce_ball, 250, 300);

		size(rankSnake, 250, 300);
		size(rankPac, 250, 300);
		size(rankBounce, 250, 300);

		snake.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pac_man.setCursor(new Cursor(Cursor.HAND_CURSOR));
		bounce_ball.setCursor(new Cursor(Cursor.HAND_CURSOR));

		snake.setIcon(new ImageIcon(
				new ImageIcon("image/snake_logo.png").getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH)));
		pac_man.setIcon(new ImageIcon(
				new ImageIcon("image/pac_man_logo.png").getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH)));
		bounce_ball.setIcon(new ImageIcon(new ImageIcon("image/bounce_ball_logo.png").getImage().getScaledInstance(250,
				300, Image.SCALE_SMOOTH)));

		log.setMargin(new Insets(5, 5, 5, 5));
		log.setFont(new Font("hy?߰???", Font.BOLD, 13));
		appendToPane(log, "???? ???? ?غ???...\n", Color.LIGHT_GRAY);
		appendToPane(log, "?ʱ?ȭ??...\n", Color.LIGHT_GRAY);
		appendToPane(log, "?ʱ?ȭ ?Ϸ?!\n", Color.GRAY);
		appendToPane(log, "?Ѹ? ?غ???...\n", Color.LIGHT_GRAY);
		appendToPane(log, "?Ѹ? ?غ? ????!\n", Color.GRAY);
		appendToPane(log, "??????ũ ?غ???...\n", Color.LIGHT_GRAY);
		appendToPane(log, "??????ũ ????!\n", Color.GRAY);
		appendToPane(log, "?ٿ?? ?غ???...\n", Color.LIGHT_GRAY);
		appendToPane(log, "?ٿ?? ????!\n", Color.GRAY);
		appendToPane(log, "???? ?˻???..*\n", Color.LIGHT_GRAY);
		appendToPane(log, "???ҽ? ?ҷ???????...\n", Color.LIGHT_GRAY);
		appendToPane(log, "???ΰ? ??????...\n", Color.LIGHT_GRAY);
		appendToPane(log, "+--------------------------+\n", Color.LIGHT_GRAY);
		appendToPane(log, "\n", Color.LIGHT_GRAY);
		appendToPane(log, "???? ???? ???? ????! \n", Color.black);

		log.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				super.keyPressed(e);
				e.consume();
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				super.keyTyped(e);
				e.consume();
			}
		});

		// ???? ????
		snake.addActionListener(e -> {
			if (ch == 0) {
				appendToPane(log, "??????ũ ???? ?غ???...\n", new Color(162, 209, 73));
				new snake.snake();
				appendToPane(log, "??????ũ ???? ????!\n", Color.green);
				ch = 1;
			}
		});

		pac_man.addActionListener(e -> {
			if (ch == 0) {
				appendToPane(log, "?Ѹ? ???? ?غ???...\n", Color.yellow);
				new pac_man.pac_man();
				appendToPane(log, "?Ѹ? ???? ????!\n", new Color(213, 208, 0));
				ch = 1;
			}
		});

		bounce_ball.addActionListener(e -> {
			if (ch == 0) {
				appendToPane(log, "?ٿ?? ???? ?غ???...\n", new Color(54, 247, 252));
				new bounce_ball();
				appendToPane(log, "?ٿ?? ???? ????!\n", new Color(3, 181, 185));
				ch = 1;
			}
		});

		sh();
	}

	public static void appendToPane(JTextPane tp, String msg, Color c) {
		StyleContext sc = StyleContext.getDefaultStyleContext();
		AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, c);

		aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Lucida Console");
		aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);

		int len = tp.getDocument().getLength();
		tp.setCaretPosition(len);
		tp.setCharacterAttributes(aset, false);
		tp.replaceSelection(msg);
		log.setSelectionStart(log.getText().length());
	}

	public static void main(String[] args) {
		new main_gameland();
	}
}
