package api.Command;

import main.mainClass;
import api.Subsystem.Subsystem;

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
		if (mainClass.thisBoard.robot.enabled) {
			id = mainClass.thisBoard.robot.manage.addThread(this);
			mainClass.thisBoard.robot.manage.start(id);
			
		}
	}

	protected void end() {

	}

	protected void requires(Subsystem stuff) {

	}

}
