package edu.wpi.first.wpilibj;

public class Timer {

	double startTime = 0;
	
	public void start() {
		startTime = System.nanoTime();
	}
	
	public void cancel() {
	
	}
	
	public void reset() {
		startTime = System.nanoTime();
	}
	
	public double get() {
		return (System.nanoTime() - startTime)/1000000000;
	}
}
