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
	final double SPEED_FRACTION = .5;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	WPI_TalonSRX leftRearMotor = new WPI_TalonSRX(0);
	WPI_TalonSRX rightRearMotor = new WPI_TalonSRX(1);
	WPI_TalonSRX rightFrontMotor = new WPI_TalonSRX(2);
	WPI_TalonSRX leftFrontMotor = new WPI_TalonSRX(3);
	SpeedControllerGroup leftSpeedController = new SpeedControllerGroup(leftFrontMotor,leftRearMotor);
	SpeedControllerGroup rightSpeedController = new SpeedControllerGroup(rightFrontMotor,rightRearMotor);
	
	DifferentialDrive dDrive = new DifferentialDrive(leftSpeedController, rightSpeedController);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new CanDriveCommand());
    }
   
    public void driveWithCanMotors() {
    	double x = Robot.OI.getDriveXAxisValue();
    	double y = Robot.OI.getDriveYAxisValue();
    	dDrive.arcadeDrive(y*SPEED_FRACTION, x*SPEED_FRACTION);
    	SwLogger.info("x = " + String.valueOf(x) + ", "+ "y = " + String.valueOf(y));
    	
    }
    private double f(double x) {
    	return Math.pow(x, 3);
    }
}

