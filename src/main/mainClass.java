package main;

import java.awt.Toolkit;

import javax.swing.JFrame;

import net.java.games.input.Component;
import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;
import circutBoard.board;

public class mainClass {

	public static board	thisBoard;
	public static int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width; // In pixels
	public static int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height; // In pixels

	public static void main(String[] args) {
		thisBoard = new board();
		thisBoard.pack();
		thisBoard.setBounds(0, 0, screenWidth, screenHeight);
		thisBoard.setVisible(true);
		thisBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void createJaguar(int portNum) {
		thisBoard.createJaguar(portNum);
	}
	
	public static void createLimitSwitch(int portNum) {
		thisBoard.createLimitSwitch(portNum);
	}
	
	public static void createEncoder(int portNum) {
		thisBoard.createEncoder(portNum);
	}

	public static void initGame() {
		thisBoard.pack();
		thisBoard.setBounds(0, 0, screenWidth, screenHeight);
		thisBoard.setVisible(true);
		thisBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
