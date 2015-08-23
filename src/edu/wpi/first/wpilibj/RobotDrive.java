package edu.wpi.first.wpilibj;

import main.Main;

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

	public RobotDrive(int i, int j) {
		// TODO Auto-generated constructor stub
	}

	public void setExpiration(double expiration) {

	}

	public void setInvertedMotor(int kFrontLeft, boolean b) {

	}

	public void setSafetyEnabled(boolean b) {
		// TODO Auto-generated method stub

	}

	public void tankDrive(double left, double right) {
		frontLeft.set(left);
		frontRight.set(right);
		backLeft.set(left);
		backRight.set(right);
	}

	public void mecanumDrive_Cartesian(double x, double y, double rotation, double gyroAngle) {
		double xIn = x;
		double yIn = y;
		// Negate y for the joystick.
		yIn = -yIn;
		// Compenstate for gyro angle.

		double wheelSpeeds[] = new double[4];
		wheelSpeeds[MotorType.kFrontLeft_val - 1] = xIn + yIn + rotation;
		wheelSpeeds[MotorType.kFrontRight_val - 1] = -xIn + yIn - rotation;
		wheelSpeeds[MotorType.kRearLeft_val - 1] = -xIn + yIn + rotation;
		wheelSpeeds[MotorType.kRearRight_val - 1] = xIn + yIn - rotation;

		normalize(wheelSpeeds);
		frontLeft.set(wheelSpeeds[MotorType.kFrontLeft_val - 1]);
		frontRight.set(wheelSpeeds[MotorType.kFrontRight_val - 1]);
		backLeft.set(wheelSpeeds[MotorType.kRearLeft_val - 1]);
		backRight.set(wheelSpeeds[MotorType.kRearRight_val - 1]);
	}

	protected static void normalize(double wheelSpeeds[]) {
		double maxMagnitude = Math.abs(wheelSpeeds[0]);
		int i;
		for (i = 1; i < 4; i++) {
			double temp = Math.abs(wheelSpeeds[i]);
			if (maxMagnitude < temp)
				maxMagnitude = temp;
		}
		if (maxMagnitude > 1.0) {
			for (i = 0; i < 4; i++) {
				wheelSpeeds[i] = wheelSpeeds[i] / maxMagnitude;
			}
		}
	}
	
	public class MotorType {

		public static final int kFrontLeft = 1;
		public static final int kFrontRight = 2;
		public static final int kRearLeft = 3;
		public static final int kRearRight = 4;
		public static final int kFrontLeft_val = 1;
		public static final int kFrontRight_val = 2;
		public static final int kRearLeft_val = 3;
		public static final int kRearRight_val = 4;
		
		
	}

	public void arcadeDrive(Joystick joystick1) {
		// TODO Auto-generated method stub
		
	}

	public void arcadeDrive(double move, double rotate) {
		// TODO Auto-generated method stub
		
	}

}
