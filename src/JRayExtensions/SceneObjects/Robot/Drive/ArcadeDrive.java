package JRayExtensions.SceneObjects.Robot.Drive;

import JRayExtensions.RobotScene;
import main.Main;

public class ArcadeDrive extends BasicDrive {

	public ArcadeDrive() {
		super();
	}

	@Override
	public void move() {
		super.move();
		resetMomentum();
		leftVerticalMomentum += super.frontLeft.currentMomentum;
		rightVerticalMomentum += super.frontRight.currentMomentum;
		leftVerticalMomentum += super.backLeft.currentMomentum;
		rightVerticalMomentum += super.backRight.currentMomentum;
		((RobotScene) (Main.display.currentScene)).myRobot.move(leftVerticalMomentum, rightVerticalMomentum, frontHorizontalMomentum, backHorizontalMomentum);
	}
}
