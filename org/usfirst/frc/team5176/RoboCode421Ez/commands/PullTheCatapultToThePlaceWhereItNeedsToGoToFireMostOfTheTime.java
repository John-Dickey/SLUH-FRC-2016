package org.usfirst.frc.team5176.RoboCode421Ez.commands;

import org.usfirst.frc.team5176.RoboCode421Ez.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PullTheCatapultToThePlaceWhereItNeedsToGoToFireMostOfTheTime extends Command {
	static double triple;
    public PullTheCatapultToThePlaceWhereItNeedsToGoToFireMostOfTheTime(double triple) {//the name is just for the lolz, it is the timeout
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.triple = triple;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(triple);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.catapultArm.tighten();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.catapultArm.stopMotor();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
