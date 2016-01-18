package edu.wpi.first.wpilibj;

import org.iraiders.robotSimulator.Main.Main;

public class Encoder {

	public int portNum;
	public double distanceTraveled = 0;
	public double distancePerPulse = 0;
	
	public Encoder(int portNum1, int portNum2) {
		portNum = portNum1;
		Main.thisBoard.encodersManager.addEncoder(this);
	}
	
	public Encoder() {
		portNum = -1;
	}
	
	public double getDistance() {
		return Main.thisBoard.encodersManager.encoders[portNum].distanceTraveled;
	}
	
	public void setDistancePerPulse(double distance) {
		distancePerPulse = distance;
	}

	public void reset() {
		Main.thisBoard.encodersManager.encoders[portNum].distanceTraveled = 0;
	}

	
}