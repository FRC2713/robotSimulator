package api.inputs;

import api.Command.Command;

public class JoystickButton extends Command {

	boolean pressed;
	Command whileHeld;
	Command whenPressed;
	Command whenReleased;
	int buttonID;
	Joystick controller;
	boolean pushedIn = false;
	
	public JoystickButton(Joystick controller1, int buttonID1) {
		controller = controller1;
		buttonID = buttonID1;
		start();
	}
	
	public void execute() {
		if(Controllers.ca[controller.portNum].getComponents()[buttonID].getPollData() > 0) {
			if(pushedIn == false) {
				whenPressed.execute();
			}
			whileHeld.start();
			pushedIn = true;
		} else {
			if(pushedIn == true) {
				whenReleased.execute();
			}
			pushedIn = false;
		}
	}
	
	public void whileHeld(Command stuff) {
		whileHeld = stuff;
	}
	
	public void whenReleased(Command stuff) {
		whileHeld = stuff;
	}
	
	public void whenPressed(Command stuff) {
		whileHeld = stuff;
	}
	
	public boolean isFinished() {
		return false;
	}
	
}
