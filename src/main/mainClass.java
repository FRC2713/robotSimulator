package main;

import java.awt.Toolkit;

import javax.swing.JFrame;

import net.java.games.input.Component;
import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;
import circutBoard.board;

public class mainClass {

	public static board thisBoard;
	public static int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width; // In pixels
	public static int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height; // In pixels

	public static void main(String[] args) {
		 Controller[] ca = ControllerEnvironment.getDefaultEnvironment().getControllers();

	        for(int i =2;i<ca.length;i++){

	            /* Get the name of the controller */
	            System.out.println(ca[i].getName());         
	        	if(ca[i].getName().equals("Logitech Attack 3")) {
	        		System.out.println(i);
	        	}
	            System.out.println("Type: "+ca[i].getType().toString());

	            /* Get this controllers components (buttons and axis) */
	            Component[] components = ca[i].getComponents();
	            System.out.println("Component Count: "+components.length);
	            for(int j=0;j<components.length;j++){
	                
	                /* Get the components name */
	                System.out.println("Component "+j+": "+components[j].getName());
	                System.out.println("    Identifier: "+ components[j].getIdentifier().getName());
	                System.out.print("    ComponentType: ");
	                if (components[j].isRelative()) {
	                    System.out.print("Relative");
	                } else {
	                    System.out.print("Absolute");
	                }
	                if (components[j].isAnalog()) {
	                    System.out.print(" Analog");
	                } else {
	                    System.out.print(" Digital");
	                }
	            }
	        }
	        System.out.println(ca.length);
	     //System.out.println((ca[2].getComponents()[2]).getPollData());

		initGame();
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
		thisBoard = new board();
		thisBoard.pack();
		thisBoard.setBounds(0, 0, screenWidth, screenHeight);
		thisBoard.setVisible(true);
		thisBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		thisBoard.startCode();
	}
	
}
