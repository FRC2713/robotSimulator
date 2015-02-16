package api.Sensors;

import java.util.ArrayList;

import main.mainClass;

public class EncoderManager extends Thread {
	ArrayList<Encoder> encoders = new ArrayList<Encoder>();;
	ArrayList<Boolean> running = new ArrayList<Boolean>();

	public void run() {
		while (true) {
			try {
				try {
					try {
						Thread.sleep(17);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					for (int i = 0; i < encoders.size(); i++) {
						encoders.get(i).distanceTravled += encoders.get(i).distancePerPulse
								* mainClass.thisBoard.jags[Integer.parseInt(mainClass.thisBoard.encoderJagNum[encoders.get(i).portNum].getText())].speed;
						mainClass.thisBoard.encoders[encoders.get(i).portNum].setText(Double.toString(encoders.get(i).distanceTravled));
					}
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
					}
				} catch (NullPointerException ex) {

				}
			} catch (NumberFormatException ex) {

			}
		}
	}

	public int addThread(Encoder toAdd) {
		encoders.add(toAdd);
		return encoders.size() - 1;
	}

	public double getDistance(int which) {
		return encoders.get(which).distanceTravled;
	}

}
