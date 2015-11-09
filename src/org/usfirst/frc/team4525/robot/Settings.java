package org.usfirst.frc.team4525.robot;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Settings {
	
	private static SendableChooser am;
	
	public enum Driver {
		Eric;
	}
	
	public enum AutoMode {
		Nothing, // Robot Does Nothing
		Autozone,
		Grab_Bin,
		Bin_Nooble;
	}
	
	public void init() {
		// Autonomous Chooser
		am = new SendableChooser();
		am.addDefault("Do Nothing", AutoMode.Nothing);
		am.addObject("To Autozone", AutoMode.Autozone); // Out of the way
		am.addObject("Bin Grab Field To Autozone", AutoMode.Grab_Bin); //Get the bin thing and go
		am.addObject("Prepare Bin for Noodling", AutoMode.Bin_Nooble);
		// 
		SmartDashboard.putData("Autonomous Mode", am);
	}
	
	public static AutoMode getAutonomous() {
		return (AutoMode)am.getSelected();
	}	
	
}
