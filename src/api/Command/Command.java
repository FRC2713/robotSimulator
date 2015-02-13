package api.Command;

public class Command extends Thread {
	
	public void run() {
		while(!isFinished()) {
			execute();
			try {
				Command.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public Boolean isFinished() { 
		return false;
	}
	
	public void execute() {
		
	}

}
