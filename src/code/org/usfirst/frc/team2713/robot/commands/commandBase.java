package code.org.usfirst.frc.team2713.robot.commands;

public class commandBase extends Command {
	public static DriveSubsystem drive;
	public static LiftSubsystem lift;
	public static GrabberSubsystem grab;
	public boolean isCreated;

	public void initLift() {
		if (lift == null) {
			lift = new LiftSubsystem();
		}
	}

	public void initDrive() {
		if (drive == null) {
			drive = new DriveSubsystem();
		}
		drive.initMechanumDrive();
	}

	public void initGrab() {
		if (grab == null) {
			grab = new GrabberSubsystem();
		}
		grab.intiCommand();
	}

	protected void initialize() {

	}

	protected void execute() {

	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}
}
