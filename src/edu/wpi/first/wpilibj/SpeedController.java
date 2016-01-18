package edu.wpi.first.wpilibj;

import org.iraiders.robotSimulator.Main.Main;

import edu.wpi.first.wpilibj.can.CANMessageNotFoundException;

public class SpeedController {

	int portNum;
	int multiplier = 1;
	double speed = 0;
	
	public SpeedController(int portNum1) {
		portNum = portNum1;
		Main.createJaguar(portNum1);
	}

	public void set(double speed) {
		if (Main.thisBoard.robot.enabled) {
			this.speed = speed * multiplier;
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

	public double get() {
		return speed;
	}
}
