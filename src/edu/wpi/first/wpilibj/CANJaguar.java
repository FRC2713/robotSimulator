package edu.wpi.first.wpilibj;


public class CANJaguar extends SpeedController {
		
	public CANJaguar(int portNum1) {
		super(portNum1);
	}
	
	public double getBusVoltage() {
		return 0;
	}
	
}
