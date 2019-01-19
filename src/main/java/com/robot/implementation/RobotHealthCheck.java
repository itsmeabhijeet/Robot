package com.robot.implementation;

import static com.robot.model.Constants.*;

import com.robot.model.Color;
import com.robot.model.Robot;

/**
 * @author Abhijeet Gupta
 *
 */
public class RobotHealthCheck {

	public boolean isOverweight(double weight) {
		if (weight > MAX_WEIGHT_CAPACITY) {
			System.out.println("Overweight");
			return false;
		}
		return true;
	}

	public boolean powerCheck(Robot r, double requiredCharging) {
		double availableCharging = r.getBatteryStatus();
		if (availableCharging < requiredCharging) {
			System.out.println("Insufficient Battery for the task");
			return false;
		} else {
			double remaining = availableCharging - requiredCharging;
			r.setBatteryStatus(remaining);
			if (remaining < LOW_BATTERY_INDICATOR) {
				r.setHealthIndicator(Color.RED);
			}
			return true;
		}

	}

}
