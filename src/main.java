import java.awt.Toolkit;

import javax.swing.JFrame;

import circutBoard.board;


public class main {
	
	public static board main;
	public static int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width; // In pixels
	public static int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height; // In pixels
	
	public static void main(String[] args) {
		main = new board();
		main.pack();
		main.setBounds(0, 0, screenWidth, screenHeight);
		main.setVisible(true);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
