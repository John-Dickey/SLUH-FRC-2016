package org.usfirst.frc.team5176.RoboCode421Ez.commands;

import org.usfirst.frc.team5176.RoboCode421Ez.Robot;
import org.usfirst.frc.team5176.RoboCode421Ez.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LosenTubingTension extends Command {

    public LosenTubingTension() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(.5);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	RobotMap.catapultArmCatapultMotor.pidWrite(Robot.UNLOADED_POSITION_OF_THE_CATAPULT);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
