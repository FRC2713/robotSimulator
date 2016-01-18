package org.iraiders.robotSimulator.circutBoard;

import org.iraiders.robotSimulator.JRayExtensions.RobotScene;
import org.iraiders.robotSimulator.Main.Main;

public class updateThread extends Thread {

	public void run() {
		while (true) {
			if (!Main.sorting) {
				((RobotScene) (Main.display.currentScene)).myRobot.myDrive.move();
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
