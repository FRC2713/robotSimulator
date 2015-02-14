package api.Sensors;

public class Timer extends Thread {

	boolean started = false;
	int timePassed;
	
	
	public void run() {
		while(true) {
			while(started) {
				timePassed++;
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public void start() {
		started = true;
	}
	
	public void cancel() {
		started = false;
	}
	
	public void reset() {
		timePassed = 0;
	}
	
	public int get() {
		return timePassed;
	}
}
