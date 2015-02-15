package code.org.usfirst.frc.team2713.robot.commands;

import api.Sensors.*;

public class goForward extends commandBase{
	
	double distance;
	Timer time;
	
	public goForward(double distance1) {
		time = new Timer();
		distance = distance1;
		//drive.thisEncoder.reset();
	}
	
    protected void initialize() {
        time.reset();
        time.start();
    }
	
	public void execute() {
		drive.move(.7);
	}

	public boolean isFinished() {
//        if(drive.thisEncoder.getDistance() > distance*12) {
//            drive.move(0);
//            return true;
//        }else {
//            return false;
//        }
    	  return false;
    }
	
}
