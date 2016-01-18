package edu.wpi.first.wpilibj;

import org.iraiders.robotSimulator.Main.Main;

public class DigitalInput {

	int portNum;
	
	public DigitalInput(int portNum1) {
		portNum = portNum1;
		Main.createLimitSwitch(portNum);
	}
	
	public boolean get() {
		return Main.thisBoard.limitSwitches[portNum].pressed;
	}
	
}
