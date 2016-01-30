// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc.team5176.RoboCode421Ez;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static SpeedController driveTrainFrontLeftMotor;
    public static SpeedController driveTrainRearLeftMotor;
    public static SpeedController driveTrainFrontRightMotor;
    public static SpeedController driveTrainRearRightMotor;
    public static RobotDrive driveTrainRobotDrive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrainFrontLeftMotor = new VictorSP(0);
        LiveWindow.addActuator("Drive Train", "Front Left Motor", (VictorSP) driveTrainFrontLeftMotor);
        
        driveTrainRearLeftMotor = new VictorSP(1);
        LiveWindow.addActuator("Drive Train", "Rear Left Motor", (VictorSP) driveTrainRearLeftMotor);
        
        driveTrainFrontRightMotor = new VictorSP(2);
        LiveWindow.addActuator("Drive Train", "Front Right Motor", (VictorSP) driveTrainFrontRightMotor);
        
        driveTrainRearRightMotor = new VictorSP(3);
        LiveWindow.addActuator("Drive Train", "Rear Right Motor", (VictorSP) driveTrainRearRightMotor);
        
        driveTrainRobotDrive = new RobotDrive(driveTrainFrontLeftMotor, driveTrainRearLeftMotor,
              driveTrainFrontRightMotor, driveTrainRearRightMotor);
        
        driveTrainRobotDrive.setSafetyEnabled(true);
        driveTrainRobotDrive.setExpiration(0.1);
        driveTrainRobotDrive.setSensitivity(0.5);
        driveTrainRobotDrive.setMaxOutput(1.0);


        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}
