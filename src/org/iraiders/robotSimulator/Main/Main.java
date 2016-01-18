package org.iraiders.robotSimulator.Main;

import java.awt.GraphicsEnvironment;


import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.iraiders.robotSimulator.JRayExtensions.RobotScene;
import org.iraiders.robotSimulator.JRayExtensions.SceneObjects.Robot.Motor;
import org.iraiders.robotSimulator.JRayExtensions.SceneObjects.Robot.Drive.ArcadeDrive;
import org.iraiders.robotSimulator.JRayExtensions.SceneObjects.Robot.Drive.MechanumDrive;
import org.iraiders.robotSimulator.circutBoard.board;
import org.iraiders.robotSimulator.circutBoard.updateThread;
import org.usfirst.frc.team2713.robot.Robot;

import com.ryanb3.TaskManager.TaskManager;
import com.ryanb3.JRay.Display.Display;

public class Main { // The class the begins the engine
					// It also manages and stores the engines objects

	// Make it so camera position is saved in the scene
	public static int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
	public static int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
	public static Display display; //= new Display(new TaskManager(), screenWidth, screenHeight);
	public static int sensitivityLower = 1;
	public static int sensitivityUpper = 10;
	public static board thisBoard;
	public static boolean sorting = false;
	public static updateThread updater;
	private static RobotScene myScene;
	static int frontLeftController = 0;
	static int frontRightController = 0;
	static int backLeftController = 0;
	static int backRightController = 0;


	public static void main(String[] args) { // The main method, starts the engine
		createDisplay();
		thisBoard = new board();
		thisBoard.robot = new Robot();
		thisBoard.robot.setEnabledDisabled(true);
		thisBoard.robot.robotInit();
		myScene = new RobotScene(display);
		pollUser();
		display.addScene(myScene);
		updater = new updateThread();
		thisBoard.robot.teleopInit();
		thisBoard.robot.teleopPeriodic();
		updater.start();
	}

	public static void createJaguar(int portNum) {
		thisBoard.createJaguar(portNum);
	}

	public static void createLimitSwitch(int portNum) {
		thisBoard.createLimitSwitch(portNum);
	}

	// Make it so camera position is saved in the scene

	public static void createDisplay() { // Inits and Makes the JFrame visible
		display = new Display(new TaskManager(), screenWidth, screenHeight);
		display.pack();
		display.setBounds(0, 0, (int) (GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().getWidth()), (int) (GraphicsEnvironment.getLocalGraphicsEnvironment()
				.getMaximumWindowBounds().getHeight()));
		display.setVisible(true);
		display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		display.hideCursor(true);
		display.screenOffset = (int) ((int) (screenHeight) - GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().getHeight());
		display.display.loadSettings();
		display.setLayout(null);
	}
	
	public static void pollUser() {
		String driveType = JOptionPane.showInputDialog("Press 1 if you want a mechanum drive, 2 if you want an arcade drive.");
		if(driveType.equals("1")) {
			myScene.myRobot.myDrive = new MechanumDrive();
		} else if(driveType.equals("2")) {
			myScene.myRobot.myDrive = new ArcadeDrive();
		} else {
			myScene.myRobot.myDrive = new ArcadeDrive();
		}
		String motorEncode = JOptionPane.showInputDialog("Enter what port number Encoder is controlled by the Front Left Motor. If none, enter nothing");
		if(motorEncode.equals("")) {
			motorEncode = "-1";
		}
		myScene.myRobot.myDrive.frontLeft = new Motor(1, frontLeftController, Integer.parseInt(motorEncode));
		motorEncode = JOptionPane.showInputDialog("Enter what port number Encoder is controlled by the Front Right Motor. If none, enter nothing");
		if(motorEncode.equals("")) {
			motorEncode = "-1";
		}
		myScene.myRobot.myDrive.frontRight = new Motor(1, frontRightController, Integer.parseInt(motorEncode));
		motorEncode = JOptionPane.showInputDialog("Enter what port number Encoder is controlled by the Back Left Motor. If none, enter nothing");
		if(motorEncode.equals("")) {
			motorEncode = "-1";
		}
		myScene.myRobot.myDrive.backLeft = new Motor(1, backLeftController, Integer.parseInt(motorEncode));
		motorEncode = JOptionPane.showInputDialog("Enter what port number Encoder is controlled by the Back Right Motor. If none, enter nothing");
		if(motorEncode.equals("")) {
			motorEncode = "-1";
		}
		myScene.myRobot.myDrive.backRight = new Motor(1, backRightController, Integer.parseInt(motorEncode));
	}
	
	public static void reportDriveInfo(int frontLeft, int frontRight, int backLeft, int backRight) {
		frontLeftController = frontLeft;
		frontRightController = frontRight;
		backLeftController = backLeft;
		backRightController = backRight;
	}

}
