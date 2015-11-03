
package org.usfirst.frc.team4525.robot.commands;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4525.robot.OI;
import org.usfirst.frc.team4525.robot.Robot;
import org.usfirst.frc.team4525.robot.RobotMap;

/**
 *
 */
public class XboxControllerDrive extends Command {
	
    public XboxControllerDrive() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    
    protected void execute() {
    	double pow = OI.getDriveStickAxis(RobotMap.driveForwardBackward);
    	double off = OI.getDriveStickAxis(RobotMap.driveLeftRight);
    	// Sprint
    	Robot.drive.setSprint(OI.getButtonPressed(RobotMap.sprintDriveButton));
    	// Stop
    	Robot.drive.setBrake(OI.getButtonPressed(RobotMap.stopDriveButton));
    	// Drive
    	Robot.drive.arcadeDrive(off, pow);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
