package code.org.usfirst.frc.team2713.robot.subsystems;

import code.org.usfirst.frc.team2713.robot.RobotMap;
import code.org.usfirst.frc.team2713.robot.UniversalController;
import api.Sensors.DigitalInput;
import api.Sensors.Encoder;
import api.Subsystem.Subsystem;

public class LiftSubsystem extends Subsystem {

	public int currentLevel = 0;
	UniversalController arm;
	public Encoder thisEncoder;
	public int lastPossition = 0;
	public double heightOfArm = 72.8;
	public double gearRatio = .04166;
	public double pulses = 48;
	public double distancePerRotation = 11.0 * gearRatio;
	public double distancePerPulse = distancePerRotation/pulses;
	public final double[] totesLocation;
	public final double toteHeight = 12.1;
	public DigitalInput limitSwitchBottom;
	public DigitalInput limitSwitchTop;
	public boolean atBottom = false;
	public boolean atTop = false;

	public LiftSubsystem() {
		arm = new UniversalController(RobotMap.LIFT_MOTOR);
		thisEncoder = new Encoder(RobotMap.LIFT_ENCODER_A_CHANNEL, RobotMap.LIFT_ENCODER_B_CHANNEL);
		thisEncoder.setDistancePerPulse(distancePerPulse);
		thisEncoder.reset();
		totesLocation = new double[6];
		limitSwitchBottom = new DigitalInput(RobotMap.BOTTOM_LIMIT_SWITCH_LIFT);
		limitSwitchTop = new DigitalInput(RobotMap.TOP_LIMIT_SWITCH_LIFT);
		for (int i = 0; i < 6; i++) {
			totesLocation[i] = toteHeight * i;
		}
	}

	public void lift(int polarity) {
		arm.getProperController().set(polarity);
	}

	public void initDefaultCommand() {

	}

}
