package circutBoard;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class jaguar extends JPanel {

	double speed = 0;
	
	public jaguar() {
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.fillRect(0, 0, 100, 100);
		if (speed == 0) {
			g.setColor(Color.orange);
		} else if (speed > 0) {
			g.setColor(Color.green);
		} else if (speed < 0) {
			g.setColor(Color.red);
		}
		g.fillOval(40, 40, 20, 20);
	}
	
	public void setSpeed(double speed1) {
		speed = speed1;
	}
	
}
