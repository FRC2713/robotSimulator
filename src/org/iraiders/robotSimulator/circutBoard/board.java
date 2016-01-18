package org.iraiders.robotSimulator.circutBoard;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import org.iraiders.robotSimulator.Main.Main;
import org.usfirst.frc.team2713.robot.Robot;

import edu.wpi.first.wpilibj.EncoderManager;
import edu.wpi.first.wpilibj.command.CommandManager;

public class board {

	public jaguar[] jags;
	public limitSwitch[] limitSwitches;
	int jaguarNum;
	int numOfSensors = 0;
	public Robot robot;
	public CommandManager manager = new CommandManager();
	public EncoderManager encodersManager = new EncoderManager();

	public board() {
		jags = new jaguar[10];
		limitSwitches = new limitSwitch[20];
		addLim1Key(Main.display.display);
		addLim2Key(Main.display.display);
		addLim3Key(Main.display.display);
		addLim4Key(Main.display.display);
		addLim5Key(Main.display.display);
		addLim6Key(Main.display.display);
		addLim7Key(Main.display.display);
		addLim8Key(Main.display.display);
		addLim9Key(Main.display.display);
		addLim10Key(Main.display.display);
		jaguarNum = 0;
	}

	public void createJaguar(int portNum) {
		jags[portNum] = new jaguar(portNum);
	}

	public void createLimitSwitch(int portNum) {
		limitSwitches[portNum] = new limitSwitch();
	}

	public void addLim1Key(JComponent jc) {
		jc.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_1, 0, false), "1 pressed");
		jc.getActionMap().put("1 pressed", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				limitSwitches[0].pressed = !limitSwitches[0].pressed;
			}
		});
	}

	public void addLim2Key(JComponent jc) {
		jc.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_2, 0, false), "2 pressed");
		jc.getActionMap().put("2 pressed", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				limitSwitches[1].pressed = !limitSwitches[1].pressed;
			}
		});
	}

	public void addLim3Key(JComponent jc) {
		jc.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_3, 0, false), "3 pressed");
		jc.getActionMap().put("3 pressed", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				limitSwitches[2].pressed = !limitSwitches[2].pressed;
			}
		});
	}

	public void addLim4Key(JComponent jc) {
		jc.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_4, 0, false), "4 pressed");
		jc.getActionMap().put("4 pressed", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				limitSwitches[3].pressed = !limitSwitches[3].pressed;
			}
		});
	}

	public void addLim5Key(JComponent jc) {
		jc.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_5, 0, false), "5 pressed");
		jc.getActionMap().put("5 pressed", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				limitSwitches[4].pressed = !limitSwitches[4].pressed;

			}
		});
	}

	public void addLim6Key(JComponent jc) {
		jc.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_6, 0, false), "6 pressed");
		jc.getActionMap().put("6 pressed", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				limitSwitches[5].pressed = !limitSwitches[5].pressed;

			}
		});
	}

	public void addLim7Key(JComponent jc) {
		jc.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_7, 0, false), "7 pressed");
		jc.getActionMap().put("7 pressed", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				limitSwitches[6].pressed = !limitSwitches[6].pressed;

			}
		});
	}

	public void addLim8Key(JComponent jc) {
		jc.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_8, 0, false), "8 pressed");
		jc.getActionMap().put("8 pressed", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				limitSwitches[7].pressed = !limitSwitches[7].pressed;

			}
		});
	}

	public void addLim9Key(JComponent jc) {
		jc.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_9, 0, false), "9 pressed");
		jc.getActionMap().put("9 pressed", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				limitSwitches[8].pressed = !limitSwitches[8].pressed;

			}
		});
	}

	public void addLim10Key(JComponent jc) {
		jc.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_0, 0, false), "0 pressed");
		jc.getActionMap().put("0 pressed", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				limitSwitches[9].pressed = !limitSwitches[9].pressed;

			}
		});
	}

	public class listenToEnableDisable implements ActionListener {

		boolean teleop;
		boolean auto;
		boolean disable;

		public listenToEnableDisable(boolean teleop1, boolean auto1, boolean disable1) {
			teleop = teleop1;
			auto = auto1;
			disable = disable1;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (disable) {
				robot.setEnabledDisabled(false);
			} else {
				if (teleop && auto) {
					robot = new Robot();
					robot.setEnabledDisabled(true);
					robot.robotInit();
					robot.autonomousInit();
					robot.autonomousPeriodic();
					robot.teleopInit();
					robot.teleopPeriodic();
				} else if (teleop) {
					robot = new Robot();
					robot.setEnabledDisabled(true);
					robot.robotInit();
					robot.teleopInit();
					robot.teleopPeriodic();
				} else if (auto) {
					robot = new Robot();
					robot.setEnabledDisabled(true);
					robot.robotInit();
					robot.autonomousInit();
					robot.autonomousPeriodic();
				}

			}

		}

	}

}