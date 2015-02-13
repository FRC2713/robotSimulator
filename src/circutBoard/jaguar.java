package circutBoard;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class jaguar extends JPanel{

	protected void paintComponent(Graphics g) {
		g.fillRect(0, 0, 200, 200);
		g.setColor(Color.orange);
		g.fillOval(80, 80, 40, 40);
	}
	
}
