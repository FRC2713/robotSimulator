package JRayExtensions;

import java.util.ArrayList;



import JRay.Geometry.Polygon3D;
import JRay.Scene.Scene;
import JRayExtensions.SceneObjects.Robot.Robot;

public class RobotScene extends Scene {

	public Robot myRobot; 
	
	public RobotScene() {
		super();
		myRobot = new Robot();
	}
	
	@Override
	public ArrayList<Polygon3D> getCurrent() {
		ArrayList<Polygon3D> toReturn = new ArrayList<Polygon3D>();
		for(int i = 0; i < super.current.size(); i++) {
			toReturn.add(super.current.get(i));
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
		for(int i = 0; i < super.current.size(); i++) {
			super.current.get(i).updateDistance();
		}
	}
	
	public void setType() {
		
	}
	
	
}
