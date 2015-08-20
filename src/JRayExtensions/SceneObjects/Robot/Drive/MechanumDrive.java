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
		double rotate = ((RobotScene) (Main.display.currentScene)).myRobot.radiansRotated;
		if (super.frontMomentum > 0 && super.backMomentum < 0) {
			((RobotScene) (Main.display.currentScene)).myRobot.shift(0, Math.cos(rotate) * (super.frontMomentum - super.backMomentum) / 2, 0);
		}
		if (super.frontMomentum < 0 && super.backMomentum > 0) {
			((RobotScene) (Main.display.currentScene)).myRobot.shift(0, -Math.cos(rotate) * (super.frontMomentum - super.backMomentum) / 2, 0);
		}
		if (super.frontMomentum > 0 && super.backMomentum > 0) {
			((RobotScene) (Main.display.currentScene)).myRobot.rotate(-.0174 * (super.frontMomentum + super.backMomentum) / 2); // Rotate to the left, is negative
			//((RobotScene) (Main.display.currentScene)).myRobot.shift(Math.cos(rotate) * (super.frontMomentum + super.backMomentum) / 2, Math.sin(rotate) * (super.frontMomentum + super.backMomentum) / 2, 0);
		}
		if (super.frontMomentum < 0 && super.backMomentum < 0) {
			((RobotScene) (Main.display.currentScene)).myRobot.shift(Math.cos(rotate) * (super.frontMomentum + super.backMomentum) / 2, Math.sin(rotate) * (super.frontMomentum + super.backMomentum) / 2, 0);
		}
		if (super.leftMomentum > super.rightMomentum) {
			((RobotScene) (Main.display.currentScene)).myRobot.rotate(-.0174 * super.leftMomentum - super.rightMomentum); // Rotate to the left, is negative
		}
		if (super.leftMomentum > super.rightMomentum) {
			((RobotScene) (Main.display.currentScene)).myRobot.rotate(.0174 * super.rightMomentum - super.leftMomentum); // Rotate to the right, is positive
		}
	}
}
