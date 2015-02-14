package api.Sensors;

import main.mainClass;

public class Encoder {

	int portNum;
	
	public Encoder(int portNum1, int portNum2) {
		portNum = portNum1;
		mainClass.createEncoder(portNum1);
	}
	
	public double getDistance() {
		if()
		return Double.parseDouble(mainClass.thisBoard.encoders[portNum].getText());
	}
	
	public void setDistancePerPulse(double distance) {
		
	}
	
}
