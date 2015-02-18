package edu.wpi.first.wpilibj.command;

import java.util.ArrayList;

public class CommandGroup extends Command {

	ArrayList<Command> commands;
	ArrayList<Boolean> run;
	boolean isFinished = false;
	int commandToRun = 0;
	public CommandGroup() {
		commands = new ArrayList<Command>();
		run = new ArrayList<Boolean>();
	}
	
	
	public void execute() {
		if(!isFinished) {
			if(commands.size() > commandToRun) {
				if(!commands.get(commandToRun).isFinished()) {
					commands.get(commandToRun).execute();
				} else {
					commandToRun++;
					System.out.println(commandToRun);
				}
			}
		}
	}
	
	public void addSequential(Command stuff) {
		commands.add(stuff);
		run.add(false);
	}

	public void addSequential(Command stuff, double time) {
		commands.add(stuff);
		run.add(false);
	}
	
}