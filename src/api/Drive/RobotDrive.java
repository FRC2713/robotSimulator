package api.Drive;

import api.SpeedControllers.CANJaguar;
import api.SpeedControllers.SpeedController;

public class RobotDrive {

	CANJaguar frontLeft;
	CANJaguar frontRight;
	CANJaguar backLeft;
	CANJaguar backRight;
	
	public RobotDrive(SpeedController frontLeft1, SpeedController frontRight1, SpeedController backLeft1, SpeedController backRight1) {
		frontLeft = (CANJaguar) frontLeft1;
		frontRight = (CANJaguar) frontRight1;
		backLeft = (CANJaguar) backLeft1;
		backRight = (CANJaguar) backRight1;
	}
	
	public RobotDrive(int frontLeftPort, int frontRightPort, int backLeftPort, int backRightPort) {
		frontLeft = new CANJaguar(frontLeftPort);
		frontRight = new CANJaguar(frontRightPort);
		backLeft = new CANJaguar(backLeftPort);
		backRight = new CANJaguar(backRightPort);
	}
	
	public void setExpiration(double expiration) {
		
	}

	public void setInvertedMotor(int kFrontLeft, boolean b) {
		
	}

	public void setSafetyEnabled(boolean b) {
		// TODO Auto-generated method stub
		
	}
	
	
}
