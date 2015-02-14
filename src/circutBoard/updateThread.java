package circutBoard;

import main.mainClass;

public class updateThread extends Thread {
	
	public void run() {
		while(true) {
			try {
			mainClass.thisBoard.updateItems();
			} catch(NullPointerException ex) {
				
			}
		}
	}
	
}
