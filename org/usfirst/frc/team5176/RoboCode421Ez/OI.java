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

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team5176.RoboCode421Ez.commands.*;
import org.usfirst.frc.team5176.RoboCode421Ez.subsystems.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public JoystickButton pilotButton1;
    public JoystickButton pilotButton2;
    public Joystick pilotJoystick;
    public JoystickButton raiseButton;
    public JoystickButton lowerButton;
    public JoystickButton spinInButton;
    public JoystickButton spinOutButton;
    public JoystickButton shootBall;
    public JoystickButton reloadButton;
    public JoystickButton scissorsUpButton;
    public JoystickButton scissorsDownButton;
    public JoystickButton switchButton;
    public JoystickButton extraButton;
    public Joystick coJoystick;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        coJoystick = new Joystick(1);
        //Free Buttons for Co-Pilot:
        extraButton = new JoystickButton(coJoystick, 12);
        extraButton.whileHeld(new ExtraCoPilotCommand());
        switchButton = new JoystickButton(coJoystick, 11);
        switchButton.whileHeld(new CameraSwitch());
        scissorsDownButton = new JoystickButton(coJoystick, 10);
        scissorsDownButton.whileHeld(new ScissorsDown());
        scissorsUpButton = new JoystickButton(coJoystick, 9);
        scissorsUpButton.whileHeld(new ScissorsUp());
        reloadButton = new JoystickButton(coJoystick, 2);
        reloadButton.whileHeld(new Reload());
        shootBall = new JoystickButton(coJoystick, 1);
        shootBall.whileHeld(new PullBackTheCatapultThing());
        spinOutButton = new JoystickButton(coJoystick, 7);
        spinOutButton.whileHeld(new SpinPickupArmsOut());
        spinInButton = new JoystickButton(coJoystick, 8);
        spinInButton.whileHeld(new SpinPickupArmsIn());
        lowerButton = new JoystickButton(coJoystick, 5);
        lowerButton.whileHeld(new LowerPickupArms());
        raiseButton = new JoystickButton(coJoystick, 3);
        raiseButton.whileHeld(new RaisePickupArms());
        pilotJoystick = new Joystick(0);
        
        pilotButton2 = new JoystickButton(pilotJoystick, 3);
        pilotButton2.whileHeld(new ExtraPilotCommand2());
        pilotButton1 = new JoystickButton(pilotJoystick, 2);
        pilotButton1.whileHeld(new ExtraPilotCommand1());


        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("Arcade Drive", new ArcadeDrive());
        SmartDashboard.putData("Raise Pickup Arms", new RaisePickupArms());
        SmartDashboard.putData("Lower Pickup Arms", new LowerPickupArms());
        SmartDashboard.putData("Spin Pickup Arms In", new SpinPickupArmsIn());
        SmartDashboard.putData("Spin Pickup Arms Out", new SpinPickupArmsOut());
        SmartDashboard.putData("Reload", new Reload());
        SmartDashboard.putData("Scissors Up", new ScissorsUp());
        SmartDashboard.putData("Scissors Down", new ScissorsDown());
        SmartDashboard.putData("Camera Switch", new CameraSwitch());
        SmartDashboard.putData("Pickup Ball", new PickupBall());
        SmartDashboard.putData("Drive To Defense", new DriveToDefense());
        SmartDashboard.putData("Drive Over Defense", new DriveOverDefense());
        SmartDashboard.putData("Line Up Shot", new LineUpShot());
        SmartDashboard.putData("Return to Neutral Zone", new ReturntoNeutralZone());
        SmartDashboard.putData("Shoot Ball PID", new PullBackTheCatapultThing());
        SmartDashboard.putData("Autonomous Command Group", new AutonomousCommandGroup());
        SmartDashboard.putData("Extra CoPilot Command", new ExtraCoPilotCommand());
        SmartDashboard.putData("Extra Pilot Command 1", new ExtraPilotCommand1());
        SmartDashboard.putData("Extra Pilot Command 2", new ExtraPilotCommand2());

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getPilotJoystick() {
        return pilotJoystick;
    }

    public Joystick getCoJoystick() {
        return coJoystick;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

