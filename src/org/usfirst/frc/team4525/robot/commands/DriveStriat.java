
package org.usfirst.frc.team4525.robot.commands;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4525.robot.Robot;
import org.usfirst.frc.team4525.robot.RobotMap;

/**
 *
 */
public class DriveStriat extends Command {

	private static int finalDistance = 0;
	private static double power;
	
	// Other Dependancies
	private static Gyro gyro;
	private static Encoder encoder;
	
    public DriveStriat(int distance, double speed) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drive);
        
        // Sensor Dependancies
        gyro = new Gyro(RobotMap.gyroIn);
        encoder = new Encoder(RobotMap.encoderSignalA,RobotMap.encoderSignalB,false, EncodingType.k4X);
        encoder.setDistancePerPulse(RobotMap.encoderPulseMultiplier);
        
        encoder.reset();
        gyro.reset();
        
        // Auto Drive Dependancies
        finalDistance = distance;
        power = speed;
        //
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	while (encoder.getDistance() < finalDistance) {
    		double offset = gyro.getAngle() * 0.15;
    		if (offset > 0.15) offset = 0.15;
    		if (offset < -0.15) offset = -0.15;
    		Robot.drive.arcadeDrive(power, offset);
    	}
    	Robot.drive.arcadeDrive(0, 0);
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
