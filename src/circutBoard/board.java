package circutBoard;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import main.mainClass;
import code.org.usfirst.frc.team2713.robot.Robot;

public class board extends JFrame {

	updateThread updater;
	public jaguar[] jags;
	public limitSwitch[] limitSwitches;
	public encoder[] encoders;
	int jaguarNum;
	int numOfSensors = 0;
	public Robot robot;
	boolean limitSwitchPressed = false;
	int limitSwitchPressedNum;
	JButton enableTeleop;
	JButton enableAuto;
	JButton enableComp;
	JButton[] disable;

	public board() {
		setLayout(null);
		jags = new jaguar[10];
		limitSwitches = new limitSwitch[10];
		encoders = new encoder[10];
		updater = new updateThread();
		updater.start();
		jaguarNum = 0;
		robot = new Robot();
		enableTeleop = new JButton("Enable Teleop");
		enableTeleop.setBounds(100, mainClass.screenHeight - 300, 100, 50);
		enableTeleop.addActionListener(new listenToEnableDisable(true, false, false));
		add(enableTeleop);
		enableAuto = new JButton("Enable Autonomous");
		enableAuto.setBounds(100, mainClass.screenHeight - 230, 100, 50);
		enableAuto.addActionListener(new listenToEnableDisable(false, true, false));
		add(enableAuto);
		enableComp = new JButton("Simulate Competition");
		enableComp.setBounds(100, mainClass.screenHeight - 160, 100, 50);
		enableComp.addActionListener(new listenToEnableDisable(true, true, false));
		add(enableComp);
		disable = new JButton[3];
		for(int i = 0; i < disable.length; i++) {
			disable[i] = new JButton("Disable");
			disable[i].setBounds(250, mainClass.screenHeight - (300 - 70*i), 100, 50);
			disable[i].addActionListener(new listenToEnableDisable(false, false, true));
			add(disable[i]);
		}
	}

	public void createJaguar(int portNum) {
		jaguarNum++;
		jags[portNum] = new jaguar();
		if (jaguarNum <= 4) {
			jags[portNum].setBounds(150 * jaguarNum - 1, 100, 100, 100);
		} else if (jaguarNum <= 8) {
			jags[portNum].setBounds(150 * (jaguarNum - 4), 300, 100, 100);
		} else {
			jags[portNum].setBounds(150 * (jaguarNum - 5), 500, 100, 100);
		}
		add(jags[portNum]);
		repaint();

	}

	public void createLimitSwitch(int portNum) {
		numOfSensors++;
		limitSwitches[portNum] = new limitSwitch(portNum);
		limitSwitches[portNum].setBounds(800 + 150 * numOfSensors % 2,
				50 + 100 * numOfSensors / 2, 150, 50);
		limitSwitches[portNum].addActionListener(new listenToLimitSwitch(
				portNum));
		add(limitSwitches[portNum]);
	}

	public void createEncoder(int portNum) {
		numOfSensors++;
		encoders[portNum] = new encoder();
		encoders[portNum].setBounds(800 + 150 * numOfSensors % 2,
				50 + 100 * numOfSensors / 2, 150, 15);
		encoders[portNum].reset();
		add(encoders[portNum]);
	}

	public void updateItems() {
		for (int i = 0; i < jags.length; i++) {
			if (jags[i] != null) {
				jags[i].repaint();
			}
		}
		this.repaint();

	}

	public class listenToLimitSwitch implements ActionListener {

		int portNum;

		public listenToLimitSwitch(int portNum1) {
			portNum = portNum1;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			limitSwitches[portNum].pressed = !limitSwitches[portNum].pressed;
			limitSwitchPressed = true;
			limitSwitchPressedNum = portNum;
		}
	}

	public class listenToEnableDisable implements ActionListener {

		boolean teleop;
		boolean auto;
		boolean disable;

		public listenToEnableDisable(boolean teleop1, boolean auto1,
				boolean disable1) {
			teleop = teleop1;
			auto = auto1;
			disable = disable1;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (disable) {
				robot.setEnabledDisabled(false);
			} else {
				if(teleop && auto) {
					robot.setEnabledDisabled(true);
					robot.robotInit();
					robot.autonomousInit();
					robot.autonomousPeriodic();
					robot.teleopInit();
					robot.teleopPeriodic();
				} else if (teleop) {
					robot.setEnabledDisabled(true);
					robot.robotInit();
					robot.teleopInit();
					robot.teleopPeriodic();
				} else if(auto) {
					robot.setEnabledDisabled(true);
					robot.robotInit();
					robot.autonomousInit();
					robot.autonomousPeriodic();
				}

			}

		}

	}

}
