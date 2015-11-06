package org.usfirst.frc.team4525.robot.commands;

import org.usfirst.frc.team4525.robot.OI;
import org.usfirst.frc.team4525.robot.Robot;
import org.usfirst.frc.team4525.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class WinchController extends Command {
	
	DigitalInput topSwitch = new DigitalInput(RobotMap.limit_TopSwitch);
	DigitalInput bottomSwitch = new DigitalInput(RobotMap.limit_BottomSwitch);
	DigitalInput frontSwitch = new DigitalInput(RobotMap.limit_FrontSwitch);
	DigitalInput backSwitch = new DigitalInput(RobotMap.limit_BackSwitch);
	
    public WinchController() {
        requires(Robot.winch);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    
    protected void execute() {
    	double posUD = OI.getMechStickAxis(RobotMap.winchMovingAxis)*-1;
    	double posLR = OI.getMechStickAxis(RobotMap.winchLRaxis);
    	// Moving Up and Down
    	if (posUD < -0.75 || (!bottomSwitch.get() && !(posUD > 0))) {
    		Robot.winch.moveY(0);
    	} else if(Robot.winch.getBrake() < posUD && topSwitch.get()) {
    		Robot.winch.moveY(posUD);
    	} else {
    		Robot.winch.brake();
    	}
    	
    	if ((posLR > 0.75 || posLR < -0.75) && ((frontSwitch.get() || posLR < 0) && (backSwitch.get() || posLR > 0))){
    		Robot.winch.moveX(posLR);
    	} else {
    		Robot.winch.moveX(0);
    	}
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
