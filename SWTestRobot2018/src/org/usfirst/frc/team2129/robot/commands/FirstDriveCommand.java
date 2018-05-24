package org.usfirst.frc.team2129.robot.commands;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Command;

public class FirstDriveCommand extends Command{

	private RobotDrive m_drive;
	private Joystick m_joystick;
	private int m_xAxis;
	private int m_yAxis;
	
	public FirstDriveCommand(int rightMotor, int leftMotor, Joystick joystick, int xAxis, int yAxis)
	{
		m_drive = new RobotDrive(rightMotor, leftMotor);
		m_joystick = joystick;
		m_xAxis = xAxis;
		m_yAxis = yAxis;
	}
	
	protected void execute() {
		m_drive.arcadeDrive(m_joystick, m_yAxis, m_joystick, m_xAxis);
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
