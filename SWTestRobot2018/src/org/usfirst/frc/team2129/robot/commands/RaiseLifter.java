package org.usfirst.frc.team2129.robot.commands;

import org.usfirst.frc.team2129.robot.OI;
import org.usfirst.frc.team2129.robot.subsystems.DriveTrainSubsystem;
import org.usfirst.frc.team2129.robot.subsystems.LifterSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RaiseLifter extends Command {

	LifterSubsystem m_subsystem;
	OI m_oi;
	
    public RaiseLifter(LifterSubsystem subsystem, OI oi) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	m_subsystem = subsystem;
    	m_oi = oi;
    	requires(m_subsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	int direction = 0;
    	if (m_oi.isRaisingLifter()) direction = 1;
    	else if (m_oi.isLoweringLifter()) direction = -1;
    	m_subsystem.run(direction);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {

    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
