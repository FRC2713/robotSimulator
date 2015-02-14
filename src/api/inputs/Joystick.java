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
		return thisController.getComponents()[xPortNum].getPollData();
	}

    public double getY() {
    	Controllers.ca[portNum].poll();
		return thisController.getComponents()[yPortNum].getPollData();
    }
    
    public double getZ() {
    	Controllers.ca[portNum].poll();
		return thisController.getComponents()[13].getPollData();
    }

    public double getRawAxis(int axis) {
    	Controllers.ca[portNum].poll();
    	return thisController.getComponents()[axis].getPollData();
    }

    public boolean getRawButton(int port) {
    	Controllers.ca[portNum].poll();
    	if(thisController.getComponents()[port].getPollData() > 0) {
    		return true;
    	}
    	return false;
    }

}
