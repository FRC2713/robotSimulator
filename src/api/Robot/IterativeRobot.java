package api.Robot;

import api.Command.CommandManager;
import api.Sensors.EncoderManager;

public class IterativeRobot {
	
	public boolean enabled = false;
	public CommandManager manage;
	public EncoderManager encoders;
	
	public IterativeRobot() {
		enabled = false;
		manage = new CommandManager();
		manage.start();
		encoders = new EncoderManager();
		encoders.start();
		
	}
	
	public void robotInit() {

	}
	
	public void disabledPeriodic() {
		
	}
	
	public void autonomousInit() {
		
	}
	
	public void autonomousPeriodic() {
		
	}
	
	public void teleopInit() {
		
	}
	
	public void teleopPeriodic() {
		
	}
	
	public void testPeriodic() {
		
	}
	
	public void setEnabledDisabled(boolean state) {
		enabled = state;
	}
	
}
