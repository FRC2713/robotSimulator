package edu.wpi.first.wpilibj;

import main.Main;
import net.java.games.input.Controller;

public class GenericHID {

	Controller thisController;
	int xPortNum;
	int yPortNum;
	int zPortNum;
	int portNum;
	int additive;

	private static String OS = System.getProperty("os.name").toLowerCase();

	public GenericHID(int port) {
		portNum = port;
		thisController = Controllers.ca[port];
		for(int i = 0; i < Controllers.ca.length; i++) {
			System.out.println(Controllers.ca[i]);
		}
		Controllers.ca[port].poll();
		for (int i = 0; i < thisController.getComponents().length; i++) {
			if (isWindows()) {
				xPortNum = 2;
				yPortNum = 1;
				zPortNum = 0;
				additive = 3;
			} else if (isMac()) {
				if (thisController.getComponents()[i].getIdentifier().getName() == "x") {
					xPortNum = i;
				}
				if (thisController.getComponents()[i].getIdentifier().getName() == "y") {
					yPortNum = i;
				}
				if (thisController.getComponents()[i].getIdentifier().getName() == "z") {
					zPortNum = i;
				}
				additive = 0;
			}
		}
	}

	public double getX() {
		if (Main.thisBoard.robot.enabled) {
			Controllers.ca[portNum].poll();
			return calcDeadban(
					thisController.getComponents()[xPortNum].getPollData(), .1);
		}
		return 0;
	}

	public double getY() {
		if (Main.thisBoard.robot.enabled) {
			Controllers.ca[portNum].poll();
			return calcDeadban(
					thisController.getComponents()[yPortNum].getPollData(), .1);
		}
		return 0;
	}

	public double getZ() {
		if (Main.thisBoard.robot.enabled) {
			Controllers.ca[portNum].poll();
			return calcDeadban(
					thisController.getComponents()[zPortNum].getPollData(), .1);
		}
		return 0;
	}

	public double getRawAxis(int axis) {
		if (Main.thisBoard.robot.enabled) {
			Controllers.ca[portNum].poll();
			return calcDeadban(
					thisController.getComponents()[axis + additive]
							.getPollData(),
					.1);
		}
		return 0;
	}

	public boolean getRawButton(int port) {
		if (Main.thisBoard.robot.enabled) {
			Controllers.ca[portNum].poll();
			if (calcDeadban(
					thisController.getComponents()[port + additive]
							.getPollData(),
					.1) > 0) {
				return true;
			}
		}
		return false;
	}

	private double calcDeadban(double value, double deadban) {
		int sign = (value > 0 ? 1 : -1); // checks the sign of the value
		value *= sign; // changes the value to positive
		if (value <= deadban) {
			return 0.0; // returns 0 if it is less than deadban
		} else {
			return (value - deadban) * sign; // returns vale minus deadban
		}
	}

	public static boolean isWindows() {
		return (OS.indexOf("win") >= 0);
	}

	public static boolean isMac() {
		return (OS.indexOf("mac") >= 0);
	}

	public double getTwist() {
		// TODO Auto-generated method stub
		return getZ();
	}
}
