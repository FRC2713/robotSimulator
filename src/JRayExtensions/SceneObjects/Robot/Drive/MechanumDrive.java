package JRayExtensions.SceneObjects.Robot.Drive;

import main.Main;

import JRayExtensions.RobotScene;

public class MechanumDrive extends BasicDrive {

	double frontHorizontalMomentum = 0; // Positive is to the right
	double backHorizontalMomentum = 0; // Positive is to the right
	double leftVerticalMomentum = 0; // Positive is up;
	double rightVerticalMomentum = 0; // Positive is up;

	public MechanumDrive() {
		super();
	}

	@Override
	public void move() {
		super.move();
		resetMomentum();
		leftVerticalMomentum += super.frontLeft.currentMomentum;
		frontHorizontalMomentum += super.frontLeft.currentMomentum;
		rightVerticalMomentum += super.frontRight.currentMomentum;
		frontHorizontalMomentum -= super.frontRight.currentMomentum;
		leftVerticalMomentum += super.backLeft.currentMomentum;
		backHorizontalMomentum -= super.backLeft.currentMomentum;
		rightVerticalMomentum += super.backRight.currentMomentum;
		backHorizontalMomentum += super.backRight.currentMomentum;
		((RobotScene) (Main.display.currentScene)).myRobot.move(leftVerticalMomentum, rightVerticalMomentum, frontHorizontalMomentum, backHorizontalMomentum);
	}

	public void resetMomentum() {
		rightVerticalMomentum = 0;
		leftVerticalMomentum = 0;
		backHorizontalMomentum = 0;
		frontHorizontalMomentum = 0;
	}
}
