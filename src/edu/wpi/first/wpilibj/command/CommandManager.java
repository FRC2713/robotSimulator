package edu.wpi.first.wpilibj.command;

import java.util.ArrayList;


import main.mainClass;

public class CommandManager extends Thread {
	ArrayList<Command> commands = new ArrayList<Command>();;
	ArrayList<Command> bases = new ArrayList<Command>();;
	ArrayList<Boolean> running = new ArrayList<Boolean>();

	public CommandManager() {
		start();
	}
	
	public void run() {
		while (true) {
			try {
				while (mainClass.thisBoard.robot.enabled) {
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					for (int i = 0; i < commands.size(); i++) {
						if (!commands.get(i).isFinished() && running.get(i)) {
							commands.get(i).execute();
						}
						if(commands.get(i).isFinished()) {
							commands.remove(i);
						}
					}
				}
			} catch (NullPointerException ex) {

			}
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public int addThread(Command toAdd) {
		commands.add(toAdd);
		bases.add(toAdd);
		running.add(false);
		return bases.size() - 1;
	}

	public void start(int id) {
		running.set(id, true);
	}

}
