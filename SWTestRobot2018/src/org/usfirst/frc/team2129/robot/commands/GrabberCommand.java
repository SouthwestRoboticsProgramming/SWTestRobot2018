package org.usfirst.frc.team2129.robot.commands;

import org.usfirst.frc.team2129.robot.OI;
import org.usfirst.frc.team2129.robot.SwLogger;
import org.usfirst.frc.team2129.robot.subsystems.DriveTrainSubsystem;
import org.usfirst.frc.team2129.robot.subsystems.LifterSubsystem;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GrabberCommand extends Command {

	LifterSubsystem m_subsystem;

	OI m_OI;
	
    public GrabberCommand(LifterSubsystem subsystem, OI oi) {
        m_subsystem = subsystem;
        m_OI = oi;
        
    }
/*
    protected void toggleGrabber() {
    	m_isEngaged = !m_isEngaged;
    }
*/
    // Called just before this Command runs the first time
    protected void initialize() {
    	SwLogger.info("initialize");
    	m_subsystem.grab(true);
    }
    
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
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
    	SwLogger.info("interupted"); 
    	m_subsystem.grab(false) ;
    }
}
