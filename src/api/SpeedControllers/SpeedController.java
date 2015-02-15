package api.SpeedControllers;

import main.mainClass;

public class SpeedController {

	int portNum;
	int multiplier = 1;

	public SpeedController(int portNum1) {
		portNum = portNum1;
		mainClass.createJaguar(portNum1);
	}

	public void set(double speed) {
		if (mainClass.thisBoard.robot.enabled) {
			mainClass.thisBoard.jags[portNum].setSpeed(multiplier * speed);
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
