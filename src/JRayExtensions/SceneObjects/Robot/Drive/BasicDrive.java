package JRayExtensions.SceneObjects.Robot.Drive;

import JRayExtensions.SceneObjects.Robot.Motor;

public class BasicDrive {

	public Motor frontLeft = new Motor(5, 2, -1);
	public Motor frontRight = new Motor(5, 3, -1);
	public Motor backLeft = new Motor(5, 4, -1);
	public Motor backRight = new Motor(5, 5, -1);
	double frontHorizontalMomentum = 0; // Positive is to the right
	double backHorizontalMomentum = 0; // Positive is to the right
	double leftVerticalMomentum = 0; // Positive is up;
	double rightVerticalMomentum = 0; // Positive is up;
	
	public BasicDrive() {
		
	}
	
	public void move() {
		
		frontLeft.move();
		frontRight.move();
		backLeft.move();
		backRight.move();
	}
	
	public void resetMomentum() {
		rightVerticalMomentum = 0;
		leftVerticalMomentum = 0;
		backHorizontalMomentum = 0;
		frontHorizontalMomentum = 0;
	}
	
}
