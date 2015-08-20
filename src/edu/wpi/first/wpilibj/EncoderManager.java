package edu.wpi.first.wpilibj;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class EncoderManager {
	
	public Encoder[] encoders = new Encoder[20];

	public EncoderManager() {
		
	}

	public void addEncoder(Encoder toAdd) {
		encoders[toAdd.portNum] = toAdd;
	}

	public double getDistance(int which) {
		return encoders[which].distanceTraveled;
	}

}