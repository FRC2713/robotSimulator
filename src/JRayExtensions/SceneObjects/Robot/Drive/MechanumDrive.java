package JRayExtensions.SceneObjects.Robot.Drive;

import main.Main;

import JRayExtensions.RobotScene;

public class MechanumDrive extends BasicDrive {

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
}
