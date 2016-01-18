package org.iraiders.robotSimulator.JRayExtensions;

import java.util.ArrayList;

import org.iraiders.robotSimulator.JRayExtensions.SceneObjects.Robot.Robot;

import com.ryanb3.JRay.Display.Display;
import com.ryanb3.JRay.Geometry.Polygon3D;
import com.ryanb3.JRay.Scene.Scene;

public class RobotScene extends Scene {

	public Robot myRobot; 
	
	public RobotScene(Display display) {
		super(display);
		myRobot = new Robot(display);
	}
	
	@Override
	public ArrayList<Polygon3D> getCurrent() {
		ArrayList<Polygon3D> toReturn = new ArrayList<Polygon3D>();
		for(int i = 0; i < super.getCurrent().size(); i++) {
			toReturn.add(super.getCurrent().get(i));
		}
		for(int i = 0; i < myRobot.myPolys.size(); i++) {
			toReturn.add(myRobot.myPolys.get(i));
		}
		for(int i = 0; i < myRobot.basePlate.size(); i++) {
			toReturn.add(myRobot.basePlate.get(i));
		}
		return toReturn;
	}

	@Override
	public void updateDistances() {
		for(int i = 0; i < myRobot.myPolys.size(); i++) {
			myRobot.myPolys.get(i).updateDistance();
		}
		for(int i = 0; i < myRobot.basePlate.size(); i++) {
			myRobot.basePlate.get(i).updateDistance();
		}
		for(int i = 0; i < super.getCurrent().size(); i++) {
			super.getCurrent().get(i).updateDistance();
		}
	}
	
	public void setType() {
		
	}
	
	
}
