package kh.java.gui.swing.component;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BackgroundImageTest extends JFrame {
	
	public BackgroundImageTest() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel p = new ImagePanel("images/background.jpg");
		
		JLabel label = new JLabel("안녕");
		JButton btn = new JButton("버튼");
		
		p.add(label);
		p.add(btn);
		add(p);
		
		pack();
		setVisible(true);
	}
	
	class ImagePanel extends JPanel {
		private BufferedImage image;
		private int width;
		private int height;
		
		public ImagePanel(String fileName) {
			try {
				image = ImageIO.read(new File(fileName));
				width = image.getWidth();
				height = image.getHeight();
				
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public Dimension getPreferredSize() {
			return new Dimension(width,height);
		}
		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(image, 0, 0, this);
		}
	}
	
	public static void main(String[] args) {
		new BackgroundImageTest();
	}
}
