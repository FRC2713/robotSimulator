package edu.wpi.first.wpilibj.command;

import org.iraiders.robotSimulator.Main.Main;

public class Command {

	int id;

	public Command() {

	}

	public boolean isFinished() {
		return false;
	}

	public void execute() {

	}

	public void cancel() {

	}

	public void start() {
		if (Main.thisBoard.robot.enabled) {
			id = Main.thisBoard.manager.addThread(this);
			Main.thisBoard.manager.start(id);
			
		}
	}

	protected void end() {

	}

	protected void requires(Subsystem stuff) {

	}

}