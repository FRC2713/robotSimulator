package circutBoard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import code.org.usfirst.frc.team2713.robot.Robot;

public class board extends JFrame {

	updateThread updater;
	public jaguar[] jags;
	public limitSwitch[] limitSwitches;
	public encoder[] encoders;
	int jaguarNum;
	int numOfSensors = 0;
	Robot robot;

	public board() {
		setLayout(null);
		jags = new jaguar[10];
		limitSwitches = new limitSwitch[10];
		encoders = new encoder[10];
		updater = new updateThread();
		updater.start();
		jaguarNum = 0;
	}
	
	public void startCode() {
		robot = new Robot();
		robot.robotInit();
		robot.teleopInit();
		robot.teleopPeriodic();
	}

	public void createJaguar(int portNum) {
		jaguarNum++;
		jags[portNum] = new jaguar();
		if(jaguarNum <= 4) {
		jags[portNum].setBounds(150 * jaguarNum - 1, 100, 100, 100);
		} else if(jaguarNum <= 8) {
			jags[portNum].setBounds(150 * (jaguarNum - 5) + 100, 300, 100, 100);	
		} else {
			jags[portNum].setBounds(150 * (jaguarNum - 9) + 100, 500, 100, 100);	
		}
		add(jags[portNum]);
		repaint();
		
	}

	public void createLimitSwitch(int portNum) {
		numOfSensors++;
		limitSwitches[portNum] = new limitSwitch(portNum);
		limitSwitches[portNum].setBounds(800 + 150 * numOfSensors%2, 50 + 100*numOfSensors/2, 150, 50);
		add(limitSwitches[portNum]);
	}

	public void createEncoder(int portNum) {
		numOfSensors++;
		encoders[portNum] = new encoder();
		encoders[portNum].setBounds(800 + 150 * numOfSensors%2, 50 + 100*numOfSensors/2, 150, 100);
		add(encoders[portNum]);
	}

	public void updateItems() {
		for (int i = 0; i < jags.length; i++) {
			if (jags[i] != null) {
				jags[i].repaint();
			}
		}
		this.repaint();

	}
	
	public class listenToLimitSwitch implements ActionListener {

		int portNum;
		
		public listenToLimitSwitch(int portNum1) {
			portNum = portNum1;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			limitSwitches[portNum].pressed = !limitSwitches[portNum].pressed;
		}
		
	}

}
