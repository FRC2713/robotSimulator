package circutBoard;

import javax.swing.JButton;

public class limitSwitch extends JButton {

	public boolean pressed = false;
	
	public limitSwitch(int portNum) {
		super("Limit Switch For " + portNum);
	}
	
}
