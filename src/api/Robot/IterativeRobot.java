package api.Robot;

import api.Command.CommandManager;

public class IterativeRobot {
	
	public boolean enabled = false;
	public CommandManager manage;
	
	public IterativeRobot() {
		enabled = false;
		manage = new CommandManager();
		manage.start();
		
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
