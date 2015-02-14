package code.org.usfirst.frc.team2713.robot.subsystems;

import api.Sensors.DigitalInput;
import api.Subsystem.Subsystem;
import code.org.usfirst.frc.team2713.robot.RobotMap;
import code.org.usfirst.frc.team2713.robot.UniversalController;

public class LiftSubsystem extends Subsystem {

	public DigitalInput[] limitSwitches;
	public int currentLevel = 0;
	UniversalController arm;

	public LiftSubsystem() {
		arm = new UniversalController(RobotMap.ARM_MOTOR);
		limitSwitches = new DigitalInput[RobotMap.NUMBER_OF_LIMIT_SWITCHES];
		for (int i = 0; i < limitSwitches.length; i++) {
			if (limitSwitches[i] == null) {
				limitSwitches[i] = new DigitalInput(i);
			}
		}
	}

	public void lift(int polarity) {
		arm.getProperController().set(polarity);
	}

	public void initDefaultCommand() {
			
	}

}
