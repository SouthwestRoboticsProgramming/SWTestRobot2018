/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2129.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2129.robot.Robot;
import org.usfirst.frc.team2129.robot.SwLogger;

/**
 * An example command.  You can replace me with your own command.
 */
public class LogCommand extends Command {

	public enum LogWhat
	{
		Pressed
	}
	
	private int m_port;
	private LogWhat m_what;
	private String m_msg;
	private int m_count;
	
	public LogCommand(int whichPort, LogWhat logWhat, String logMessage) {
		m_count = 0;
		m_what = logWhat;
		m_msg = logMessage;
		m_port = whichPort;
		
		// Use requires() here to declare subsystem dependencies
		requires(Robot.kLogSubsystem);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		SwLogger.info("Port " + m_port + " " + m_what.toString() + " " + m_msg);
		m_count++;
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		if (m_count >= 10) {
			SwLogger.info("Log command has finished");
			return true;
		}
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
