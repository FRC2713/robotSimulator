package org.usfirst.frc.team2713.robot.commands;

import edu.wpi.first.wpilibj.Timer;

public class turn90Right extends commandBase {

	Timer time;

	public turn90Right() {
		time = new Timer();
		time.reset();
		time.start();
	}

	public void execute() {
		drive.rotate(.7);
	}

	public boolean isFinished() {
		if(time.get() > 1) {
			drive.move(0);
			return true;
		}
		return false;
	}

}
