package api.Sensors;

import main.mainClass;

public class DigitalInput {

	int portNum;
	
	public DigitalInput(int portNum1) {
		portNum = portNum1;
		mainClass.createLimitSwitch(portNum);
	}
	
	public boolean get() {
		return mainClass.thisBoard.limitSwitches[portNum].pressed;
	}
	
}
