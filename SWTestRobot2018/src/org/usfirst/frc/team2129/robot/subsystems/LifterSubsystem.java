package org.usfirst.frc.team2129.robot.subsystems;

import org.usfirst.frc.team2129.robot.OI;
import org.usfirst.frc.team2129.robot.RobotMap;
import org.usfirst.frc.team2129.robot.SwLogger;
import org.usfirst.frc.team2129.robot.commands.CanDriveCommand;
import org.usfirst.frc.team2129.robot.commands.RaiseLifter;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class LifterSubsystem extends Subsystem {
	final double SPEED_FRACTION = .5;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	DigitalInput UpperLimitSwitch = new DigitalInput(RobotMap.LIFTER_UPPER_SWITCH);
	DigitalInput LowerLimitSwitch = new DigitalInput(RobotMap.LIFTER_LOWER_SWITCH);
	private WPI_TalonSRX lifter_motor;
	private Solenoid grabberPiston = new Solenoid(RobotMap.GRABBER_SOLENOID_CAN, RobotMap.GRABBER_SOLENOID_PCM);
	
	private DifferentialDrive m_drive;
	private OI m_OI;
	
	public boolean isTooHigh() {
		return UpperLimitSwitch.get();
	}
	public boolean isTooLow() {
		return LowerLimitSwitch.get();
	}
	
	public  void grab(boolean isEngaged) {
		grabberPiston.set(isEngaged);
	}
	
	public LifterSubsystem(OI oi)
	{
		m_OI = oi;
		lifter_motor = new WPI_TalonSRX(RobotMap.LIFTER_MOTOR);
	}
	public void run(int direction) {
		int speed;
		if (isTooHigh()) 
		{
			SwLogger.info("too high");
			speed = Math.min(0, direction);
		}
		else if (isTooLow())
		{
			SwLogger.info("too low");
			speed = Math.max(0, direction);
		}
		else speed = direction;

		
		lifter_motor.set(speed);
	}
    public void initDefaultCommand() {
//        // Set the default command for a subsystem here.
//        setDefaultCommand(new CanDriveCommand(this));
    	setDefaultCommand(new RaiseLifter(this, m_OI));
    }
   
//    public void driveWithCanMotors() {
//    	double x = f(m_OI.getDriveXAxisValue());
//    	double y = f(m_OI.getDriveYAxisValue());
//    	m_drive.arcadeDrive(y*SPEED_FRACTION, x*SPEED_FRACTION);
//    	SwLogger.info("x = " + String.valueOf(x) + ", "+ "y = " + String.valueOf(y));
//    	
//    }
//    private double f(double x) {
//    	return Math.pow(x, 3);
//    }
}

