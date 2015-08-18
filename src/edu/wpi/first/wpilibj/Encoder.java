package edu.wpi.first.wpilibj;

import main.Main;

public class Encoder {

	int id = 0;
	public int portNum;
	public double distanceTravled = 0;
	public double distancePerPulse = 0;
	
	public Encoder(int portNum1, int portNum2) {
		portNum = portNum1;
		Main.createEncoder(portNum1);
		id = Main.thisBoard.encodersManager.addThread(this);
	}
	
	public double getDistance() {
		return Main.thisBoard.encodersManager.encoders.get(id).distanceTravled;
	}
	
	public void setDistancePerPulse(double distance) {
		distancePerPulse = distance;
	}

	public void reset() {
		Main.thisBoard.encoders[portNum].reset();
		
	}

	
}