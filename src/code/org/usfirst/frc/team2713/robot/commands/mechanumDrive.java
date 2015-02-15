package code.org.usfirst.frc.team2713.robot.commands;

import code.org.usfirst.frc.team2713.robot.OI;
import api.Prefrences.Preferences;

public class mechanumDrive extends commandBase{
	
	Preferences prefs;
	double SCALER;
	double DEADBAND;
	double POLARITY;
	
	public mechanumDrive(){
		prefs = Preferences.getInstance();
	}
	
	public void execute() {
		SCALER = prefs.getDouble("SCALER", 0.6);
		DEADBAND = prefs.getDouble("DEADBAND",0.1);
		POLARITY = -1;
		drive.roboDrive.setSafetyEnabled(false);
    	drive.TankDrive(OI.xbox.getX(), OI.xbox.getY());
    	System.out.println(drive.thisEncoder.getDistance());
	}
	
}
