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
		Turn_Get_Bin,
		Bin_Across_Field; 
	}
	
	public void init() {
		// Autonomous Chooser
		am = new SendableChooser();
		am.addDefault("Do Nothing", AutoMode.Nothing);
		am.addObject("Turn 90 Bin Stealer", AutoMode.Turn_Get_Bin);
		am.addObject("Across Bin Stealer", AutoMode.Bin_Across_Field);
		//
		SmartDashboard.putData("Autonomous Mode", am);
	}
	
	public static AutoMode getAutonomous() {
		return (AutoMode)am.getSelected();
	}
	
}
