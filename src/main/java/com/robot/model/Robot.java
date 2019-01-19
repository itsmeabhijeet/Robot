package com.robot.model;
import static com.robot.model.Constants.MAX_BATTERY;
import static com.robot.model.Constants.MAX_WALK_CAPACITY;
import static com.robot.model.Constants.MAX_WEIGHT_CAPACITY;
/**
 * @author Abhijeet Gupta
 *
 */
public class Robot {

	private double batteryStatus;
	private Color healthIndicator;
	private double remainedWalk;
	private double remainedWeight;

	
	public Robot(){
		this.batteryStatus = MAX_BATTERY;
		this.remainedWeight = MAX_WEIGHT_CAPACITY;
		this.remainedWalk = MAX_WALK_CAPACITY;
		this.healthIndicator = Color.GREEN;
	}


	/**
	 * @return the batteryStatus
	 */
	public double getBatteryStatus() {
		return batteryStatus;
	}


	/**
	 * @param batteryStatus the batteryStatus to set
	 */
	public void setBatteryStatus(double batteryStatus) {
		this.batteryStatus = batteryStatus;
	}


	/**
	 * @return the healthIndicator
	 */
	public Color getHealthIndicator() {
		return healthIndicator;
	}


	/**
	 * @param healthIndicator the healthIndicator to set
	 */
	public void setHealthIndicator(Color healthIndicator) {
		this.healthIndicator = healthIndicator;
	}


	/**
	 * @return the remainedWalk
	 */
	public double getRemainedWalk() {
		return remainedWalk;
	}


	/**
	 * @param remainedWalk the remainedWalk to set
	 */
	public void setRemainedWalk(int remainedWalk) {
		this.remainedWalk = remainedWalk;
	}


	/**
	 * @return the remainedWeight
	 */
	public double getRemainedWeight() {
		return remainedWeight;
	}


	/**
	 * @param remainedWeight the remainedWeight to set
	 */
	public void setRemainedWeight(int remainedWeight) {
		this.remainedWeight = remainedWeight;
	}

	}
