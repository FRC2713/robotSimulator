package edu.wpi.first.wpilibj.command;

import java.util.ArrayList;

public class CommandGroup extends Command {

	ArrayList<Command> commands;
	ArrayList<Boolean> run;
	public CommandGroup() {
		commands = new ArrayList<Command>();
		run = new ArrayList<Boolean>();
	}
	
	
	public void execute() {
		for(int i = 0; i < commands.size(); i++) {
			if(run.get(i) == false) {
				commands.get(i).execute();
				if(commands.get(i).isFinished() == true) {
					run.set(i, true);
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