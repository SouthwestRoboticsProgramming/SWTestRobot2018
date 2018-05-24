package org.usfirst.frc.team2129.robot.subsystems;

import org.usfirst.frc.team2129.robot.RobotMap;
import org.usfirst.frc.team2129.robot.commands.CanDriveCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class DriveSubsystem extends Subsystem {
	Talon leftMotor = new Talon(RobotMap.LEFT_CAN);
	Talon rightMotor = new Talon(RobotMap.RIGHT_CAN);
	DifferentialDrive robotDrive = new DifferentialDrive(leftMotor, rightMotor);
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
    	setDefaultCommand(new CanDriveCommand());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
	
	public void driveWithInputs(Joystick joystick, int xAxis, int yAxis)
	{
		//TODO: This might not be right- removed deprecated method, did not test yet, idk what its for :(
		robotDrive.arcadeDrive(xAxis, yAxis);
	}
	
	public void stopDriving()
	{
		robotDrive.tankDrive(0,0);
	}
	

	public void justDrive(double right, double left) {
		robotDrive.tankDrive(.3,.3);
	}
}

