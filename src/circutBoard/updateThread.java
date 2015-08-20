package circutBoard;

import main.Main;
import JRayExtensions.RobotScene;

public class updateThread extends Thread {

	public void run() {
		while (true) {
			if (!Main.sorting) {
				for (int i = 0; i < Main.thisBoard.jags.length; i++) {
					if (Main.thisBoard.jags[i] != null) {
						
					}
				}
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
