// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc.team5176.RoboCode421Ez.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.DigitalInput;

import org.usfirst.frc.team5176.RoboCode421Ez.Robot;
import org.usfirst.frc.team5176.RoboCode421Ez.RobotMap;
import org.usfirst.frc.team5176.RoboCode421Ez.commands.*;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class CatapultArm extends PIDSubsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final SpeedController catapultMotor = RobotMap.catapultArmCatapultMotor;
    private final AnalogInput armEncoder = RobotMap.catapultArmArmEncoder;
    private final Relay clamp = RobotMap.theTrigger;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final DigitalInput limitSwitch = RobotMap.catapultArmsLimitSwitch;
    // Initialize your subsystem here
    public CatapultArm() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PID
        super("CatapultArm", 1.0, 0.0, 0.0);//pid
        setAbsoluteTolerance(0.2);
        getPIDController().setContinuous(false);
        LiveWindow.addActuator("Catapult Arm", "PIDSubsystem Controller", getPIDController());

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PID

        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SOURCE
        return armEncoder.pidGet()/4000;

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SOURCE
    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=OUTPUT
        catapultMotor.pidWrite(output);
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=OUTPUT
    }
    
    public double returnVal() {
    		return returnPIDInput();
    }
    
    public void tighten() {
    		catapultMotor.set(.7);
    }
    
    public void loosen() {
    	catapultMotor.set(-.1);
    }
    
    public void stopMotor() {
    	catapultMotor.set(0);
    	// john u fuck
    	//Rob u mad?
    }
    public void release() {
    	clamp.set(Value.kReverse);
    }
    
    public void firmlyGraspIt() { //Squidward 
    	clamp.set(Value.kForward);
    }
    
    public void stopClamp() {
    	clamp.set(Value.kOff);
    }
    public void goToPos(double pos)
    {
    	if(pos > armEncoder.getValue())
    	{
    		double dist = Math.abs(armEncoder.getValue() - pos);
    		do
    		{
    			Robot.catapultArm.catapultMotor.set(armEncoder.getValue() / pos / 2);
    		}while(dist > 0);
    	}
    	if(pos < armEncoder.getValue())
    	{
    		double dist = Math.abs(armEncoder.getValue() - pos);
    		do
    		{
    			Robot.catapultArm.catapultMotor.set(-(pos / armEncoder.getValue() / 2));
    		}while(dist > 0);
    	}
    }
}
