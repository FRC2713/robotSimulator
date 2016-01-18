package edu.wpi.first.wpilibj;

import org.iraiders.robotSimulator.Main.Main;

public class SpeedController {

	int portNum;
	int multiplier = 1;

	public SpeedController(int portNum1) {
		portNum = portNum1;
		Main.createJaguar(portNum1);
	}

	public void set(double speed) {
		if (Main.thisBoard.robot.enabled) {
			Main.thisBoard.jags[portNum].setSpeed(multiplier * speed);
		}
	}

	public void setInverted(boolean trueOrFalse) {
		if (trueOrFalse) {
			multiplier = -1;
		} else {
			multiplier = 1;
		}
	}
}
