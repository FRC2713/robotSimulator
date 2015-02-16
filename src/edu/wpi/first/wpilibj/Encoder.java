package edu.wpi.first.wpilibj;

import main.mainClass;

public class Encoder {

	int id = 0;
	public int portNum;
	public double distanceTravled = 0;
	public double distancePerPulse = 0;
	
	public Encoder(int portNum1, int portNum2) {
		portNum = portNum1;
		mainClass.createEncoder(portNum1);
		id = mainClass.thisBoard.robot.encoders.addThread(this);
	}
	
	public double getDistance() {
		return mainClass.thisBoard.robot.encoders.encoders.get(id).distanceTravled;
	}
	
	public void setDistancePerPulse(double distance) {
		distancePerPulse = distance;
	}

	public void reset() {
		mainClass.thisBoard.encoders[portNum].reset();
		
	}

	
}
