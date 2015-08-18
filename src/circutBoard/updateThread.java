package circutBoard;

import main.Main;

public class updateThread extends Thread {
	
	public void run() {
		while(true) {
			Main.thisBoard.updateItems();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
