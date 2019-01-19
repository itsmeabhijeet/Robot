package com.robot.main;

import com.robot.contract.IRobotService;
import com.robot.implementation.RobotHealthCheck;
import com.robot.implementation.RobotServiceImpl;
import com.robot.model.Robot;

/**
 * @author Abhijeet Gupta
 *
 */
public class RobotConsole {
	public static void main(String[] args){
		
		IRobotService robot = new RobotServiceImpl(new Robot(),new RobotHealthCheck());
		robot.walk(3.5);
		robot.walkAndCarry(2, 3);
		robot.carry(12);
		
		
		robot.scanBarcode(30);
		robot.scanBarcode(-1);
		
		
		
	}
}
