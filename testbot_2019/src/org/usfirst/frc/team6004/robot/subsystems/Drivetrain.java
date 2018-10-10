package org.usfirst.frc.team6004.robot.subsystems;

import org.usfirst.frc.team6004.robot.RobotMap;
import org.usfirst.frc.team6004.robot.commands.DriveTank;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {
	
	// Motor Controllers
	Victor leftFrontDrive = new Victor(0);
	Victor leftRearDrive = new Victor(1);
	Victor rightFrontDrive = new Victor(2);
	Victor rightRearDrive = new Victor(3);
	
	// Robot Drive
	RobotDrive robotDrive = null;
	
	public Drivetrain() {
		// Victors
		leftFrontDrive = new Victor(RobotMap.DRIVETRAIN_LEFT_FRONT_VICTOR);
		leftRearDrive = new Victor(RobotMap.DRIVETRAIN_LEFT_BACK_VICTOR);
		rightFrontDrive = new Victor(RobotMap.DRIVETRAIN_RIGHT_FRONT_VICTOR);
		rightRearDrive = new Victor(RobotMap.DRIVETRAIN_RIGHT_BACK_VICTOR);
		
		// Robot Drive
		robotDrive = new RobotDrive(leftFrontDrive, leftRearDrive, rightFrontDrive, rightRearDrive);
	}
	
	public void tankDrive(double leftSpeed, double rightSpeed, boolean twitch) {
		//robotDrive.arcadeDrive(moveSpeed, rotateSpeed);
		robotDrive.tankDrive(leftSpeed, rightSpeed, twitch);
	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveTank());
    }
}