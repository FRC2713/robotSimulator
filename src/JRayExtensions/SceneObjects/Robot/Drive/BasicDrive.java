package JRayExtensions.SceneObjects.Robot.Drive;

import JRayExtensions.SceneObjects.Robot.Motor;

public class BasicDrive {

	public Motor frontLeft = new Motor(5, 2, -1);
	public Motor frontRight = new Motor(5, 3, -1);
	public Motor backLeft = new Motor(5, 4, -1);
	public Motor backRight = new Motor(5, 5, -1);
	
	public BasicDrive() {
		
	}
	
	public void move() {
		
		frontLeft.move();
		frontRight.move();
		backLeft.move();
		backRight.move();
	}
	
}
