package gameland;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.Timer;

import aframe.aframe;

public class gameland extends aframe{

	Runtime rt = Runtime.getRuntime();
	Process pc = null;
	JLabel snake[] = new JLabel[10];
	JLabel pacman[] = new JLabel[10];
	JLabel bounceball[] = new JLabel[10];
	
	
	public static ArrayList<Integer> pacmanscore = new ArrayList<>();
	public static ArrayList<Integer> pacmantime = new ArrayList<>();
	
	public gameland() {
		// TODO Auto-generated constructor stub
		fs("게임랜드");
		
		np.add(jl = new JLabel("고전 게임 천국"));
		jl.setFont(new Font("hy견도딕",Font.BOLD,30));
		np.setLayout(new FlowLayout());
		
		
		np.setBackground(Color.white);
		cp.setBackground(Color.white);
		sp.setBackground(Color.white);
		wp.setBackground(Color.white);
		ep.setBackground(Color.white);
		
		size(cp,700,500);
		
		
		sh();
	}
	
	Timer tm = new Timer(5000, new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				ArrayList<String> snake = new ArrayList<>();
				
				File f = new File("snakedata.hat");
				FileReader fr = new FileReader(f);
				BufferedReader br = new BufferedReader(fr);
				String line = "";
				
				while ((line = br.readLine())!= null) {
					snake.add(line);
				}
				for (int i = 0; i < snake.size(); i++) {
					
				}
				
				br.close();
				
				
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	});
	
	public static void main(String[] args) {
		new gameland();
	}

}
