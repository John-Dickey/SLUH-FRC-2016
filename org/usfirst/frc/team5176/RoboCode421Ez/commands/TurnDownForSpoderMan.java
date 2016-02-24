package org.usfirst.frc.team5176.RoboCode421Ez.commands;

import org.usfirst.frc.team5176.RoboCode421Ez.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnDownForSpoderMan extends Command {

    public TurnDownForSpoderMan() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(.5);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.scissorLift.downWeGo();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.scissorLift.stopTheMotors();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
