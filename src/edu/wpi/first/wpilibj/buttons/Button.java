package edu.wpi.first.wpilibj.buttons;

import org.iraiders.robotSimulator.Main.Main;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class Button extends Thread {

	boolean pressed;
	int whileHeldID = 0;
	int whenPressedID = 1;
	int whenReleasedID = 2;
	Command whileHeld;
	Command baseWhileHeld;
	Command whenPressed;
	Command whenReleased;
	int buttonID;
	GenericHID controller;
	boolean pushedIn = false;
	boolean started = false;
	boolean toBePressedAgain = false;

	public Button(GenericHID controller1, int buttonID1) {
		controller = controller1;
		buttonID = buttonID1;
		super.start();
	}

	public void run() {
		while (true && Main.thisBoard.robot.enabled) {
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
					whenPressed.runExecute();
					pushedIn = true;
				}
			}
			if (whileHeld != null && !toBePressedAgain) {
				if (!whileHeld.checkIsFinished()) {
					whileHeld.runExecute();
					pushedIn = true;
				} else {
					toBePressedAgain = true;
				}
			}
		} else {
			if (pushedIn == true) {
				if (whenReleased != null) {
					whenReleased.runExecute();
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
