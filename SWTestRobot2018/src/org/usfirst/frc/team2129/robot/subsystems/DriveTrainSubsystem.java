package org.usfirst.frc.team2129.robot.subsystems;

import org.usfirst.frc.team2129.robot.OI;
import org.usfirst.frc.team2129.robot.RobotMap;
import org.usfirst.frc.team2129.robot.SwLogger;
import org.usfirst.frc.team2129.robot.commands.CanDriveCommand;
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

	private WPI_TalonSRX leftRearMotor;
	private WPI_TalonSRX rightRearMotor;
	private WPI_TalonSRX rightFrontMotor;
	private WPI_TalonSRX leftFrontMotor;
	private SpeedControllerGroup leftSpeedController;
	private SpeedControllerGroup rightSpeedController;
	
	private DifferentialDrive m_drive;
	private OI m_OI;

	public DriveTrainSubsystem(OI oi)
	{
		m_OI = oi;
		leftRearMotor = new WPI_TalonSRX(RobotMap.LEFT_REAR_MOTOR);
		rightRearMotor = new WPI_TalonSRX(RobotMap.RIGHT_REAR_MOTOR);
		rightFrontMotor = new WPI_TalonSRX(RobotMap.RIGHT_FRONT_MOTOR);
		leftFrontMotor = new WPI_TalonSRX(RobotMap.LEFT_FRONT_MOTOR);
		leftSpeedController = new SpeedControllerGroup(leftFrontMotor,leftRearMotor);
		rightSpeedController = new SpeedControllerGroup(rightFrontMotor,rightRearMotor);
	
		m_drive = new DifferentialDrive(leftSpeedController, rightSpeedController);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new CanDriveCommand(this));
    }
   
    public void driveWithCanMotors() {
    	double x = f(m_OI.getDriveXAxisValue());
    	double y = f(m_OI.getDriveYAxisValue());
    	m_drive.arcadeDrive(y*SPEED_FRACTION, x*SPEED_FRACTION);
    	SwLogger.info("x = " + String.valueOf(x) + ", "+ "y = " + String.valueOf(y));
    	
    }
    private double f(double x) {
    	return Math.pow(x, 3);
    }
}

