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
		return myRobot.myPolys;
	}
	
	@Override
	public void updateDistances() {
		for(int i = 0; i < myRobot.myPolys.size(); i++) {
			myRobot.myPolys.get(i).updateDistance();
		}
	}
	
	public void setType() {
		
	}
	
	
}
