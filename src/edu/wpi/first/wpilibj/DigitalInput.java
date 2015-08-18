package edu.wpi.first.wpilibj;

import main.Main;

public class DigitalInput {

	int portNum;
	
	public DigitalInput(int portNum1) {
		portNum = portNum1;
		Main.createLimitSwitch(portNum);
	}
	
	public boolean get() {
		return !Main.thisBoard.limitSwitches[portNum].pressed;
	}
	
}
