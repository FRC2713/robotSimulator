package edu.wpi.first.wpilibj.buttons;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;

public class JoystickButton extends Button {
	
	public JoystickButton(GenericHID controller, int buttonID1) {
		super(controller, buttonID1);
	}
}
