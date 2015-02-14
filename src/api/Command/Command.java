package api.Command;

import api.Subsystem.Subsystem;

public class Command extends Thread {
		
	public void run() {
		while(!isFinished()) {
			execute();
			try {
				Command.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	protected boolean isFinished() { 
		return false;
	}
	
	public void execute() {
		
	}
	
	public void cancel() {
		this.stop();
	}
	
	protected void end() {

	}
	
	protected void requires(Subsystem stuff) {
		
	}

}
