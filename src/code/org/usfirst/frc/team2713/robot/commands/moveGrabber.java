package code.org.usfirst.frc.team2713.robot.commands;

import code.org.usfirst.frc.team2713.robot.OI;

public class moveGrabber extends commandBase {

	Boolean inOrOut;
	double triggerPolarity = OI.xbox.getX();

	public void getTiggerPolarity() {
		if (OI.xbox.getX() != 0 && OI.xbox.getZ() != 0) {
			inOrOut = null;
			triggerPolarity = 0;
		} else if (OI.xbox.getX() != 0) {
			inOrOut = true;
			triggerPolarity = OI.xbox.getX();
		} else if (OI.xbox.getZ() != 0) {
			inOrOut = false;
			triggerPolarity = OI.xbox.getZ();
		} else if (OI.xbox.getX() == 0 && OI.xbox.getZ() == 0) {
			triggerPolarity = 0;
			inOrOut = null;
		}
	}

	public moveGrabber() {
		
	}

	protected void initialize() {
		
	}

	public void execute() {
		getTiggerPolarity();
		if (inOrOut != null && inOrOut == true && !grab.armClosed.get()) {
			grab.setLift(1);
		} else if (inOrOut != null && inOrOut == false) {
			grab.setLift(-1);
		} else {
			grab.setLift(0);
		}
	}

	public boolean isFinished() {
		return false;
	}

	protected void end() {

	}

}
