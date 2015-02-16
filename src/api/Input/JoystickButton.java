package api.Input;

import main.mainClass;
import api.Command.Command;

public class JoystickButton extends Thread {

	boolean pressed;
	Command whileHeld;
	Command baseWhileHeld;
	Command whenPressed;
	Command whenReleased;
	int buttonID;
	Joystick controller;
	boolean pushedIn = false;
	boolean started = false;
	boolean toBePressedAgain = false;

	public JoystickButton(Joystick controller1, int buttonID1) {
		controller = controller1;
		buttonID = buttonID1;
		super.start();
	}

	public void run() {
		while (true && mainClass.thisBoard.robot.enabled) {
			try {
				execute();
			} catch (NullPointerException ex) {

			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void execute() {
		if (controller.getRawButton(buttonID) == true) {
			if (pushedIn == false) {
				if (whenPressed != null) {
					whenPressed.execute();
					pushedIn = true;
				}
			}
			if (whileHeld != null && !toBePressedAgain) {
				if (!whileHeld.isFinished()) {
					whileHeld.execute();
					pushedIn = true;
				} else {
					toBePressedAgain = true;
				}
			}
		} else {
			if (pushedIn == true) {
				if (whenReleased != null) {
					whenReleased.execute();
					pushedIn = false;
					toBePressedAgain = false;
				}
			}
			if (whenPressed != null) {
				whenPressed.cancel();
				pushedIn = true;
			}
		}
	}

	public void whileHeld(final Command stuff) {
		whileHeld = stuff;
		baseWhileHeld = stuff;
	}

	public void whenReleased(final Command stuff) {
		whenReleased = stuff;
	}

	public void whenPressed(final Command stuff) {
		whenPressed = stuff;
	}

	public boolean isFinished() {
		return false;
	}

}
