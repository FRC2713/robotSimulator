package org.iraiders.robotSimulator.JRayExtensions.SceneObjects.Robot;

import java.awt.Color;



import java.util.ArrayList;

import org.iraiders.robotSimulator.JRayExtensions.SceneObjects.Robot.Drive.BasicDrive;

import com.ryanb3.JRay.Display.Display;
import com.ryanb3.JRay.Geometry.Polygon3D;
import com.ryanb3.JRay.ShapeGenerator.ShapeFactory;

public class Robot {

	public ArrayList<Polygon3D> myPolys = new ArrayList<Polygon3D>();
	public ArrayList<Polygon3D> basePlate = new ArrayList<Polygon3D>();
	ArrayList<Motor> motors = new ArrayList<Motor>();
	public BasicDrive myDrive = new BasicDrive();
	public Motor liftMotor;
	public Motor grabberMotor;
	public double radiansRotated = 0;

	public Robot(Display display) {
		ShapeFactory factory = new ShapeFactory(display);
		basePlate = addArray(factory.generateCube(-100, 1000, 0, 100, new Color(255, 0, 0)), basePlate);
	}

	public ArrayList<Polygon3D> addArray(Polygon3D[] toAdd, ArrayList<Polygon3D> toAddTo) { // A method to add an array of polygons to current
		for (int i = 0; i < toAdd.length; i++) {
			toAddTo.add(toAdd[i]);
		}
		return toAddTo;
	}

	public ArrayList<Polygon3D> addArray(ArrayList<Polygon3D> toAdd, ArrayList<Polygon3D> toAddTo) {// A method to add an arraylist of polygons to current
		for (int i = 0; i < toAdd.size(); i++) {
			toAddTo.add(toAdd.get(i));
		}
		return toAddTo;
	}

	public void shift(double x, double y, double z) {
		for (int i = 0; i < myPolys.size(); i++) {
			myPolys.get(i).shift(x, y, z);
		}
		for (int i = 0; i < basePlate.size(); i++) {
			basePlate.get(i).shift(x, y, z);
		}
	}

	public void rotate(double radians, double centerX, double centerY) {
		for (int i = 0; i < myPolys.size(); i++) {
			myPolys.get(i).rotate(radians, centerX, centerY);
		}
		for (int i = 0; i < basePlate.size(); i++) {
			basePlate.get(i).rotate(radians, centerX, centerY);
		}
		radiansRotated += radians * Math.PI;
	}

	public void move(double leftVerticalMomentum, double rightVerticalMomentum, double backHorizontalMomentum, double frontHorizontalMomentum) {
		shift(Math.cos(radiansRotated) * (leftVerticalMomentum + rightVerticalMomentum) / 2, Math.sin(radiansRotated) * (leftVerticalMomentum + rightVerticalMomentum) / 2, 0); // Front Back Movement
		shift(-Math.sin(radiansRotated) * (backHorizontalMomentum + frontHorizontalMomentum) / 2, Math.cos(radiansRotated) * (backHorizontalMomentum + frontHorizontalMomentum) / 2, 0); // Right Left
																																															// Movement

		// Break

		double toRotate = Math.abs(leftVerticalMomentum - rightVerticalMomentum) * .0104; // Change to actual calculated radian amount

		// Break
		double percentYShift = 0;
		double greaterNum = 0;
		if ((Math.abs(backHorizontalMomentum) - Math.abs(frontHorizontalMomentum)) != 0) {

			greaterNum = backHorizontalMomentum;
			if (backHorizontalMomentum < frontHorizontalMomentum) {
				greaterNum = frontHorizontalMomentum;
			}
			percentYShift = greaterNum / (Math.abs(backHorizontalMomentum) - Math.abs(frontHorizontalMomentum));
		}

		// Break
		double percentXShift = 0;
		if ((Math.abs(leftVerticalMomentum) - Math.abs(rightVerticalMomentum)) != 0) {
			greaterNum = leftVerticalMomentum;
			if (leftVerticalMomentum < rightVerticalMomentum) {
				greaterNum = rightVerticalMomentum;
			}
			percentXShift = greaterNum / (Math.abs(leftVerticalMomentum) - Math.abs(rightVerticalMomentum)); // Rotation amount
		}

		// Break
		//basePlate.get(2)
		double basePlateHalfLength = Math.abs(basePlate.get(2).myPoints[0].xPos - basePlate.get(2).myPoints[2].xPos) / 2;
		double centerX = (basePlate.get(2).myPoints[0].xPos + basePlate.get(2).myPoints[2].xPos) / 2 + basePlateHalfLength * percentXShift;
		double centerY = (basePlate.get(2).myPoints[0].yPos + basePlate.get(2).myPoints[2].yPos) / 2 + basePlateHalfLength * percentYShift;
		rotate(toRotate, centerX, centerY); //Rotation from vertical momentum
	}

}
