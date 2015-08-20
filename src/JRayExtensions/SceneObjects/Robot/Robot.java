package JRayExtensions.SceneObjects.Robot;

import java.awt.Color;
import java.util.ArrayList;

import JRay.Geometry.Point3D;
import JRay.Geometry.Polygon3D;
import JRay.ShapeGenerator.ShapeFactory;
import JRayExtensions.SceneObjects.Robot.Drive.BasicDrive;

public class Robot {

	public ArrayList<Polygon3D> myPolys = new ArrayList<Polygon3D>();
	public ArrayList<Polygon3D> basePlate = new ArrayList<Polygon3D>();
	Point3D center = new Point3D(0, 0, 0);
	ArrayList<Motor> motors = new ArrayList<Motor>();
	public BasicDrive myDrive = new BasicDrive();
	public Motor liftMotor;
	public Motor grabberMotor;
	public double radiansRotated = 0;
	
	public Robot() {
		basePlate = addArray(ShapeFactory.generateCube(-100, 1000, 0, 100, new Color(255, 0, 0)), basePlate);
		center.xPos = -50;
		center.yPos = 1050;
		center.zPos = 0;
	}


	public ArrayList<Polygon3D> addArray(Polygon3D[] toAdd, ArrayList<Polygon3D> toAddTo) { //A method to add an array of polygons to current
		for (int i = 0; i < toAdd.length; i++) {
			toAddTo.add(toAdd[i]);
		}
		return toAddTo;
	}

	public ArrayList<Polygon3D> addArray(ArrayList<Polygon3D> toAdd, ArrayList<Polygon3D> toAddTo) {//A method to add an arraylist of polygons to current
		for (int i = 0; i < toAdd.size(); i++) {
			toAddTo.add(toAdd.get(i));
		}
		return toAddTo;
	}
	
	public void shift(double x, double y, double z) {
		for(int i = 0; i < myPolys.size(); i++) {
			myPolys.get(i).shift(x, y, z);
		}
		for(int i = 0; i < basePlate.size(); i++) {
			basePlate.get(i).shift(x, y, z);
		}
	}
	
	public void rotate(double radians) {
		center.xPos = (basePlate.get(2).myPoints[0].xPos + basePlate.get(2).myPoints[2].xPos) / 2;
		center.yPos = (basePlate.get(2).myPoints[0].yPos + basePlate.get(2).myPoints[2].yPos) / 2;
		for(int i = 0; i < myPolys.size(); i++) {
			myPolys.get(i).rotate(radians, center.xPos, center.yPos);
		}
		for(int i = 0; i < basePlate.size(); i++) {
			basePlate.get(i).rotate(radians, center.xPos, center.yPos);
		}
		radiansRotated += radians * Math.PI;
	}
	
}
