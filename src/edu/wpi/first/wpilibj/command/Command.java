package edu.wpi.first.wpilibj.command;

import org.iraiders.robotSimulator.Main.Main;

public class Command {

	int id;

	public Command() {

	}

	protected boolean isFinished() {
		return false;
	}

	protected void execute() {

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

	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}
	
	public void runExecute() {
		this.execute();
	}
	
	public boolean checkIsFinished() {
		return this.isFinished();
	}

}