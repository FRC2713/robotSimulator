package JRayExtensions.SceneObjects.Robot;

import java.awt.Color;
import java.util.ArrayList;

import JRay.Geometry.Polygon3D;
import JRay.ShapeGenerator.ShapeFactory;
import main.Main;

public class Robot {

	public ArrayList<Polygon3D> myPolys = new ArrayList<Polygon3D>();
	ArrayList<Motor> motors = new ArrayList<Motor>();
	
	public Robot() {
		addArray(ShapeFactory.generateCube(-100, 1000, 0, 100, new Color(255, 0, 0)));
	}


	public void addArray(Polygon3D[] toAdd) { //A method to add an array of polygons to current
		for (int i = 0; i < toAdd.length; i++) {
			myPolys.add(toAdd[i]);
		}
		Main.display.repaint();
	}

	public void addArray(ArrayList<Polygon3D> toAdd) {//A method to add an arraylist of polygons to current
		for (int i = 0; i < toAdd.size(); i++) {
			myPolys.add(toAdd.get(i));
		}
		Main.display.repaint();
	}
	
	public void shift(double d, double y, double z) {
		for(int i = 0; i < myPolys.size(); i++) {
			myPolys.get(i).shift(d, y, z);
		}
	}
	
}
