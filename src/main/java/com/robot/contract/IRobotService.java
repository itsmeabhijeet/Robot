package com.robot.contract;


/**
 * @author Abhijeet Gupta
 *
 */
public interface IRobotService {

	boolean walk(double distance);
	boolean carry(double weight);
	boolean walkAndCarry(double distance, double weight);
	boolean scanBarcode(int barcode);
	
	void chargeRobot(double percentage);
	
}
