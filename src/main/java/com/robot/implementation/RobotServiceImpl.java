package com.robot.implementation;

import com.robot.contract.IRobotService;
import com.robot.model.Robot;
import static com.robot.model.Constants.*;

/**
 * @author Abhijeet Gupta
 *
 */
public class RobotServiceImpl implements IRobotService {
	private Robot robot;
	private RobotHealthCheck robotHealth;
	static double batteryLeft;
	
	public RobotServiceImpl(Robot robot, RobotHealthCheck robotHealth) {
		this.robot = robot;
		this.robotHealth = robotHealth;
	}
	
	
	@Override
	public void chargeRobot(double percentage){
		double currentCharging = robot.getBatteryStatus();
		if(currentCharging + percentage > MAX_BATTERY)
			robot.setBatteryStatus(MAX_BATTERY);
		else{
			robot.setBatteryStatus(currentCharging+percentage);
		}
	}
	
	
	
	@Override
	public boolean walk(double km){
		   batteryLeft = robot.getBatteryStatus();
		   double requiredCharging = (double)(km*100/5);
		   if(robotHealth.powerCheck(robot, requiredCharging)){
			   System.out.println("Robot Walked "+km+"km - Battery Used "+ requiredCharging +"% - Battery left  "+ robot.getBatteryStatus() +"%");
			   System.out.println("Robot Headlight color "+ robot.getHealthIndicator());
			   return true;
		   }
		   return false;
	}

	@Override
	public boolean carry(double weight) {
			if(robotHealth.isOverweight(weight)){
				double requiredCharging = 2*weight;
				batteryLeft = robot.getBatteryStatus();
				if(robotHealth.powerCheck(robot, requiredCharging)){
					System.out.println("Robot carried "+ weight+"kg - Battery Used "+ requiredCharging +"% -  battery left  "+ robot.getBatteryStatus() +"%");
					System.out.println("Robot HeadLight Color "+ robot.getHealthIndicator());
					return true;
				}
			}
			return false;
	}
	
	@Override
	public boolean walkAndCarry(double dist, double weight) {
		if(robotHealth.isOverweight(weight)){
			double requiredCharging = (dist*1000/50) + 2*weight ;
			batteryLeft = robot.getBatteryStatus();
			if(robotHealth.powerCheck(robot, requiredCharging)){
				System.out.println("Robot Walked "+ dist + "km and Carried "+ weight+"kg - battery Used "+ requiredCharging +"% - battery left  "+ robot.getBatteryStatus() +"%");
				System.out.println("Robot HeadLight Color "+ robot.getHealthIndicator());
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean scanBarcode(int barCode){
		boolean isValidBarcode=false;
		if(barCode > 0){
			System.out.println("Price is "+ barCode);
			isValidBarcode=true;
		}else{
			System.out.println("Scan Failure");
		}
		return isValidBarcode;
	}
	

}
