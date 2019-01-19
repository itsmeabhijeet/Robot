package com.robot.implementation;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import com.robot.model.Color;
import com.robot.model.Robot;

public class RobotServiceImplTest {

	RobotServiceImpl robotService;	
	Robot robot;
	RobotHealthCheck healthCheck;
	
	@Before
	public void setUp() throws Exception {
		
		healthCheck = new RobotHealthCheck();
		robot = new Robot();
		robotService=new RobotServiceImpl(robot,healthCheck);
	}
	@Test
	public void chargeRobot_maxCharge_shouldReturnMaxCharge() {
		
		//Arrange
		double chargePercentage = 100;
		//Act
		robotService.chargeRobot(chargePercentage);
		
		//Assert
		assertEquals(chargePercentage, robot.getBatteryStatus(),0);
		
	}
	
	@Test
	public void walk_validWalk_shouldReturnRemainingBattery() {
		
		//Arrange
		double chargeToMax = 100;
		double walkingKm = 3;
		robotService.chargeRobot(chargeToMax);
		//Act
		robotService.walk(walkingKm);
		
		//Assert
		
		double batteryLeft =40;
		assertEquals(batteryLeft, robot.getBatteryStatus(),0);
		
	}
	
	@Test
	public void walk_inValidWalk_shouldBeAbleToWalk() {
		
		//Arrange
		double chargeToMax = 100;
		double walkingKm = 2;
		robotService.chargeRobot(chargeToMax);
		//Act
		Boolean result= robotService.walk(walkingKm);
		
		//Assert
		
		assertTrue(result);
	}

	@Test
	public void walk_inValidWalk_shouldNotBeAbleToWalk() {
		
		//Arrange
		double chargeToMax = 100;
		double walkingKm = 6;
		robotService.chargeRobot(chargeToMax);
		//Act
		Boolean result= robotService.walk(walkingKm);
		
		//Assert
		
		assertFalse(result);
	}
	@Test
	public void walk_validWalk_shouldRaiseIndicatorToRed() {
		
		//Arrange
		double chargeToMax = 100;
		double walkingKm = 4.5;
		robotService.chargeRobot(chargeToMax);
		//Act
		robotService.walk(walkingKm);
		
		//Assert
		assertEquals(Color.RED, robot.getHealthIndicator());
	}
	
	@Test
	public void carry_invalid_shouldNotBeableToCarry() {
		
		//Arrange
		double chargeToMax = 100;
		double weight = 12;
		robotService.chargeRobot(chargeToMax);
		//Act
		boolean canCarry=robotService.carry(weight);
		
		//Assert
		assertFalse(canCarry);
	}
	
	@Test
	public void carry_valid_shouldBeableToCarry() {
		
		//Arrange
		double chargeToMax = 100;
		double weight = 5;
		robotService.chargeRobot(chargeToMax);
		//Act
		boolean canCarry=robotService.carry(weight);
		
		//Assert
		assertTrue(canCarry);
	}

	@Test
	public void walkAndcarry_valid_shouldBeableToWalkAndCarry() {
		
		//Arrange
		double chargeToMax = 100;
		double weight = 3;
		double distance =2;
		robotService.chargeRobot(chargeToMax);
		//Act
		boolean canCarry=robotService.walkAndCarry(distance, weight);
		
		//Assert
		assertTrue(canCarry);
	}
	
	@Test
	public void scanBarCode_validBarcode_should() {
		
		//Arrange
		int validBarcode = 4;
		//Act
		boolean canScan=robotService.scanBarcode(validBarcode);
		
		//Assert
		assertTrue(canScan);
	}
	
	@Test
	public void scanBarCode_inValidBarcode_should() {
		
		//Arrange
		int inValidBarcode = -4;
		//Act
		boolean canScan=robotService.scanBarcode(inValidBarcode);
		
		//Assert
		assertFalse(canScan);
	}

}
