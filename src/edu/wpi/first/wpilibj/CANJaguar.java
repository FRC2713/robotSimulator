package edu.wpi.first.wpilibj;

import edu.wpi.first.wpilibj.can.CANMessageNotFoundException;

public class CANJaguar extends SpeedController {
		
	public CANJaguar(int portNum1) {
		super(portNum1);
		if(-1 == 0) {
			throw new CANMessageNotFoundException();
		}
	}
	
	public double getBusVoltage() {
		return 0;
	}
	
}
