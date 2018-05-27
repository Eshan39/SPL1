package spl1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ShowWinner  extends JPanel implements ActionListener,KeyListener  {

	int win;
	JFrame f;
	public ShowWinner(int win,JFrame f)  {
		this.win=win;
		this.f=f;
		JFrame frame1 = new JFrame();
	
		frame1.setBounds(420, 200, 590,330);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setResizable(false);
		frame1.setVisible(true);

		JPanel panel1 = new JPanel() {	 
			 @Override
			 public void paintComponent(Graphics g){       
				g.setColor(Color.black);
				g.setFont(new Font("serif",Font.BOLD,20));
				g.drawString("Win the Match! With  "+win+" remaining pieces ",125,280);   
			 }
		 };
		 panel1.setBounds(0, 725, 488, 1);
		 panel1.setForeground(Color.BLACK);
		 frame1.add(panel1);
		 
		 JButton UL = new JButton("New Game ");
		 UL.setFont(new Font("Times New Roman", Font.BOLD, 14));
		 UL.setBackground(Color.black);
		 UL.setForeground(Color.white);
		 UL.setBounds(215, 345, 90, 60);
		 panel1.add(UL);

		 UL.addMouseListener(new MouseListener() {	
				@Override
				public void mouseClicked(MouseEvent e) {
					frame1.setVisible(false);
					 CheckersBoard main=new CheckersBoard(f);
				}
				@Override
				public void mousePressed(MouseEvent e) {}
				@Override
				public void mouseReleased(MouseEvent e) {}
				@Override
				public void mouseEntered(MouseEvent e) {
				}
				@Override
				public void mouseExited(MouseEvent e) {				
				}
	});
		
   }
	@Override
	public void keyPressed(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void actionPerformed(ActionEvent e) {}
	
}
