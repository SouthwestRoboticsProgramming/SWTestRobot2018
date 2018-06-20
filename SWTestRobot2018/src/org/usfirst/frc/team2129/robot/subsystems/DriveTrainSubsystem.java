package org.usfirst.frc.team2129.robot.subsystems;

import org.usfirst.frc.team2129.robot.Robot;
import org.usfirst.frc.team2129.robot.SwLogger;
import org.usfirst.frc.team2129.robot.commands.CanDriveCommand;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class DriveTrainSubsystem extends Subsystem {
	final double SPEED_FRACTION = .7;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	WPI_TalonSRX leftMotor = new WPI_TalonSRX(6);
	WPI_TalonSRX rightMotor = new WPI_TalonSRX(5);
	SpeedControllerGroup leftSpeedController = new SpeedControllerGroup(leftMotor);
	SpeedControllerGroup rightSpeedController = new SpeedControllerGroup(rightMotor);
	
	DifferentialDrive dDrive = new DifferentialDrive(leftSpeedController, rightSpeedController);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new CanDriveCommand());
    }
   
    public void driveWithCanMotors() {
    	double x = Robot.OI.getDriveXAxisValue();
    	double y = Robot.OI.getDriveYAxisValue();
    	dDrive.arcadeDrive(y*SPEED_FRACTION, x*SPEED_FRACTION);
    	SwLogger.info("New CODE!!!!!!!!!!!!!!");
    	
    }
    
}
