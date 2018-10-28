package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveArcade extends Command {

    public DriveArcade() {
    		requires(Robot.drivetrain);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		double leftSpeed = Robot.oi.driverController.getRawAxis(RobotMap.JOYSTICK_MOVE_LEFT_AXIS); 
            double rightSpeed = Robot.oi.driverController.getRawAxis(RobotMap.JOYSTICK_ROTATE_RIGHT_AXIS);
    		Robot.drivetrain.arcadeDrive(leftSpeed, rightSpeed);
    }
    
    // curve inputs
    public double deadband(double JoystickValue, double DeadbandCutOff) {
    	double deadbandreturn = 0;
    	if (JoystickValue<DeadbandCutOff&&JoystickValue>(DeadbandCutOff*(-1))) {
    		deadbandreturn = 0 ;
    	}
    	else {
    		deadbandreturn = (JoystickValue-(Math.abs(JoystickValue)/JoystickValue*DeadbandCutOff))/(1-DeadbandCutOff);
    	}
    	return deadbandreturn;
    }
    
    
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    		Robot.drivetrain.arcadeDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    		end();
    }
}
