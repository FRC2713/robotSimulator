package api.inputs;

import net.java.games.input.Controller;
import api.inputs.Controllers;

public class Joystick {
	
	Controller thisController;
	int xPortNum;
	int yPortNum;
	int zPortNum;
	int portNum;
	
	public Joystick(int port) {
		portNum = port;
		thisController = Controllers.ca[port];
		Controllers.ca[port].poll();
    	for(int i = 0; i < thisController.getComponents().length; i++) {
    		if(thisController.getComponents()[i].getName() == "x") {
    			xPortNum = i;
    		}
    		if(thisController.getComponents()[i].getName() == "y") {
    			yPortNum = i;
    		}
    		if(thisController.getComponents()[i].getName() == "z") {
    			zPortNum = i;
    		}
    	}
	}

	public double getX() {
    	Controllers.ca[portNum].poll();
		return calcDeadban(thisController.getComponents()[xPortNum].getPollData(), .1);
	}

    public double getY() {
    	Controllers.ca[portNum].poll();
		return calcDeadban(thisController.getComponents()[yPortNum].getPollData(), .1);
    }
    
    public double getZ() {
    	Controllers.ca[portNum].poll();
		return calcDeadban(thisController.getComponents()[zPortNum].getPollData(), .1);
    }

    public double getRawAxis(int axis) {
    	Controllers.ca[portNum].poll();
    	return calcDeadban(thisController.getComponents()[axis].getPollData(), .1);
    }

    public boolean getRawButton(int port) {
    	Controllers.ca[portNum].poll();
    	if(calcDeadban(thisController.getComponents()[port].getPollData(), .1) > 0) {
    		return true;
    	}
    	return false;
    }
    
    private double calcDeadban(double value, double deadban) {
        int sign = (value > 0 ? 1 : -1);                //checks the sign of the value
        value *= sign;                                  //changes the value to positive
        if(value <= deadban) {                          
            return 0.0;                                 //returns 0 if it is less than deadban
        } else{
            return (value - deadban) * sign;            //returns vale minus deadban
        }
    }

}
