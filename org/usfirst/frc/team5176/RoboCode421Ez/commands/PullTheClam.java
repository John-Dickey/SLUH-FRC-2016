package org.usfirst.frc.team5176.RoboCode421Ez.commands;

import org.usfirst.frc.team5176.RoboCode421Ez.Robot;
import org.usfirst.frc.team5176.RoboCode421Ez.RobotMap;

import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PullTheClam extends Command {

    public PullTheClam() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(.2);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	RobotMap.theTrigger.set(Value.kForward);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.theTrigger.set(Value.kOff);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
