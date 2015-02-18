package circutBoard;

import main.mainClass;

public class updateThread extends Thread {
	
	public void run() {
		while(true) {
			mainClass.thisBoard.updateItems();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
