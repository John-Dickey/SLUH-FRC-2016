package org.usfirst.frc.team5176.RoboCode421Ez.commands;

import org.usfirst.frc.team5176.RoboCode421Ez.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CatapultToPosition extends Command {

    double position;
	public CatapultToPosition(double pos) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
		position = pos;
    }
	public CatapultToPosition(RealPosition pos) {
		position = pos.value;
	}
	public CatapultToPosition() {
		position = RealPosition.Unwind.value;
	}

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(.5);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	RobotMap.catapultArmCatapultMotor.pidWrite(position);
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
    enum RealPosition{
    	Unwind (69);//TODO obtain real position
    	
    	private double value;
    	
    	RealPosition(double value) {
    		this.value = value;
    	}
    }
}
