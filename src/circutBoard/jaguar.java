package circutBoard;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class jaguar extends JPanel {

	public double speed = 0;
	int portNum;
	
	
	public jaguar(int portNum1) {
		portNum = portNum1;
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
		g.setColor(Color.white);
		g.drawString("Jaguar: " + Integer.toString(portNum), 30, 20);
	}
	
	public void setSpeed(double speed1) {
		speed = speed1;
		repaint();
	}
	
}
