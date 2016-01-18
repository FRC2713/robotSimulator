package edu.wpi.first.wpilibj;

import org.iraiders.robotSimulator.Main.Main;

public class RobotDrive {

	CANJaguar m_frontLeftMotor;
	CANJaguar m_frontRightMotor;
	CANJaguar m_rearLeftMotor;
	CANJaguar m_rearRightMotor;
	boolean safe = false;
	
	
	public RobotDrive(SpeedController frontLeft1, SpeedController frontRight1, SpeedController backLeft1, SpeedController backRight1) {
		m_frontLeftMotor = (CANJaguar) frontLeft1;
		m_frontRightMotor = (CANJaguar) frontRight1;
		m_rearLeftMotor = (CANJaguar) backLeft1;
		m_rearRightMotor = (CANJaguar) backRight1;
		Main.reportDriveInfo(m_frontLeftMotor.portNum, m_frontRightMotor.portNum, m_rearLeftMotor.portNum, m_rearRightMotor.portNum);
	}

	public RobotDrive(int frontLeftPort, int frontRightPort, int backLeftPort, int backRightPort) {
		m_frontLeftMotor = new CANJaguar(frontLeftPort);
		m_frontRightMotor = new CANJaguar(frontRightPort);
		m_rearLeftMotor = new CANJaguar(backLeftPort);
		m_rearRightMotor = new CANJaguar(backRightPort);
		Main.reportDriveInfo(m_frontLeftMotor.portNum, m_frontRightMotor.portNum, m_rearLeftMotor.portNum, m_rearRightMotor.portNum);
	}

	public RobotDrive(int i, int j) {
		// TODO Auto-generated constructor stub
	}

	public void setExpiration(double expiration) {

	}

	public void setInvertedMotor(int motorID, boolean b) {
		if (motorID == MotorType.kFrontLeft) {
			m_frontLeftMotor.setInverted(b);
		}
		if (motorID == MotorType.kFrontRight) {
			m_frontRightMotor.setInverted(b);
		}
		if (motorID == MotorType.kRearLeft) {
			m_rearLeftMotor.setInverted(b);
		}
		if (motorID == MotorType.kRearRight) {
			m_rearRightMotor.setInverted(b);
		}
	}
	
	public void tankDrive(double left, double right) {
		m_frontLeftMotor.set(left);
		m_frontRightMotor.set(right);
		m_rearLeftMotor.set(left);
		m_rearRightMotor.set(right);
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
		m_frontLeftMotor.set(wheelSpeeds[MotorType.kFrontLeft_val - 1]);
		m_frontRightMotor.set(wheelSpeeds[MotorType.kFrontRight_val - 1]);
		m_rearLeftMotor.set(wheelSpeeds[MotorType.kRearLeft_val - 1]);
		m_rearRightMotor.set(wheelSpeeds[MotorType.kRearRight_val - 1]);
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
		arcadeDrive(joystick1, true);
	}

	public void arcadeDrive(double move, double rotate) {
		this.arcadeDrive(move, rotate, true);
	}

	public void arcadeDrive(GenericHID stick, boolean squaredInputs) {
		arcadeDrive(stick.getY(), stick.getX(), squaredInputs);
	}

	public void arcadeDrive(double moveValue, double rotateValue, boolean squaredInputs) {
		double leftMotorSpeed;
		double rightMotorSpeed;

		moveValue = limit(moveValue);
		rotateValue = limit(rotateValue);

		if (squaredInputs) {
			// square the inputs (while preserving the sign) to increase fine control while permitting full power
			if (moveValue >= 0.0) {
				moveValue = (moveValue * moveValue);
			} else {
				moveValue = -(moveValue * moveValue);
			}
			if (rotateValue >= 0.0) {
				rotateValue = (rotateValue * rotateValue);
			} else {
				rotateValue = -(rotateValue * rotateValue);
			}
		}

		if (moveValue > 0.0) {
			if (rotateValue > 0.0) {
				leftMotorSpeed = moveValue - rotateValue;
				rightMotorSpeed = Math.max(moveValue, rotateValue);
			} else {
				leftMotorSpeed = Math.max(moveValue, -rotateValue);
				rightMotorSpeed = moveValue + rotateValue;
			}
		} else {
			if (rotateValue > 0.0) {
				leftMotorSpeed = -Math.max(-moveValue, rotateValue);
				rightMotorSpeed = moveValue + rotateValue;
			} else {
				leftMotorSpeed = moveValue - rotateValue;
				rightMotorSpeed = -Math.max(-moveValue, -rotateValue);
			}
		}

		setLeftRightMotorOutputs(leftMotorSpeed, rightMotorSpeed);
	}

	public void setLeftRightMotorOutputs(double leftOutput, double rightOutput) {
		if (m_rearLeftMotor == null || m_rearRightMotor == null) {
			throw new NullPointerException("Null motor provided");
		}

		if (m_frontLeftMotor != null) {
			m_frontLeftMotor.set(limit(leftOutput));
		}
		m_rearLeftMotor.set(limit(leftOutput));

		if (m_frontRightMotor != null) {
			m_frontRightMotor.set(-limit(rightOutput));
		}
		m_rearRightMotor.set(-limit(rightOutput));
	}

	protected static double limit(double num) {
		if (num > 1.0) {
			return 1.0;
		}
		if (num < -1.0) {
			return -1.0;
		}
		return num;
	}

	protected static double[] rotateVector(double x, double y, double angle) {
		double cosA = Math.cos(angle * (3.14159 / 180.0));
		double sinA = Math.sin(angle * (3.14159 / 180.0));
		double out[] = new double[2];
		out[0] = x * cosA - y * sinA;
		out[1] = x * sinA + y * cosA;
		return out;
	}
	
	public void setSensitivity(double sensitivity) {
		//TODO
	}

	public void setMaxOutput(double maxOutput) {
		//TODO
	}
	public void setCANJaguarSyncGroup(byte syncGroup) {
		//TODO
	}
	
	public void free() {
		//TODO
	}

	public double getExpiration() {
		//TODO
		return 0;
	}

	public boolean isAlive() {
		return true;
	}

	public boolean isSafetyEnabled() {
		return safe;
	}

	public void setSafetyEnabled(boolean enabled) {
		safe = enabled;
	}

	public String getDescription() {
		return "Robot Drive";
	}

	public void stopMotor() {
		if (m_frontLeftMotor != null) {
			m_frontLeftMotor.set(0.0);
		}
		if (m_frontRightMotor != null) {
			m_frontRightMotor.set(0.0);
		}
		if (m_rearLeftMotor != null) {
			m_rearLeftMotor.set(0.0);
		}
		if (m_rearRightMotor != null) {
			m_rearRightMotor.set(0.0);
		}
	}

	private void setupMotorSafety() {
		//TODO
	}

	protected int getNumMotors() {
		int motors = 0;
		if (m_frontLeftMotor != null)
			motors++;
		if (m_frontRightMotor != null)
			motors++;
		if (m_rearLeftMotor != null)
			motors++;
		if (m_rearRightMotor != null)
			motors++;
		return motors;
	}

}
