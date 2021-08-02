package aframe;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.MouseInputListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class aframe extends JFrame implements ActionListener, MouseInputListener, WindowListener, KeyListener,Runnable{

	public JPanel jp1,jp2,jp3,p,pp,ppp,p1,p2,p3,p4,ap,cp,np,sp,wp,ep;
	public String bl = "";
	public Date now = new Date();
	public JLabel jl;
	public JButton jb1,jb2,jb3,jb4;
	public JTable jta;
	public DefaultTableModel dtm;
	public DefaultTableCellRenderer cell = new DefaultTableCellRenderer();
	public JScrollPane jsp;
	public SimpleDateFormat ymd = new SimpleDateFormat("yyyy-MM-dd");
	public DecimalFormat zz = new DecimalFormat("00"), won = new DecimalFormat("#,###");
	
	public void fs(String s) {
		setTitle(s);
		add(cp = new JPanel(new BorderLayout()),BorderLayout.CENTER);
		add(np = new JPanel(new BorderLayout()),BorderLayout.NORTH);
		add(sp = new JPanel(new BorderLayout()),BorderLayout.SOUTH);
		add(wp = new JPanel(new BorderLayout()),BorderLayout.WEST);
		add(ep = new JPanel(new BorderLayout()),BorderLayout.EAST);
	}
	
	public void sh() {
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
	public void imsg(String s) {
		JOptionPane.showMessageDialog(null, s,"메시지",JOptionPane.INFORMATION_MESSAGE);
	}
	public void wmsg(String s) {
		JOptionPane.showMessageDialog(null, s,"메시지",JOptionPane.ERROR_MESSAGE);
	}
	
	public int rei(String s) {
		try {
			return Integer.parseInt(s);
		} catch (Exception e) {
			// TODO: handle exception
			return 0 ;
		}
	}

	public String tv(JTable t, int c) {
		return t.getValueAt(t.getSelectedRow(), c).toString();
	}
	
	public void size(JComponent c, int x, int y) {
		c.setPreferredSize(new Dimension(x,y));
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}