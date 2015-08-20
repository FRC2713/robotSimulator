package JRayExtensions.SceneObjects.Robot;

import main.Main;

public class Motor {

	int attachedJaguarID = 0;
	int attachedEncoderID = -1;
	public double currentMomentum = 0;
	double distancePerSpin = 1;

	public Motor(double distancePerSpin, int jaguarNum, int encoderNum) {
		this.distancePerSpin = distancePerSpin;
		attachedJaguarID = jaguarNum;
		attachedEncoderID = encoderNum;
	}

	public void move() {
		currentMomentum = Main.thisBoard.jags[attachedJaguarID].speed * distancePerSpin;
		if (attachedEncoderID != -1) {
			Main.thisBoard.encodersManager.encoders[attachedEncoderID].distanceTraveled += Main.thisBoard.jags[attachedJaguarID].speed
					* Main.thisBoard.encodersManager.encoders[attachedEncoderID].distancePerPulse;
		}
	}

}
