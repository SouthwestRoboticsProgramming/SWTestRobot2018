/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2129.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2129.robot.commands.CanDriveCommand;
import org.usfirst.frc.team2129.robot.commands.RaiseLifter;
import org.usfirst.frc.team2129.robot.subsystems.DriveTrainSubsystem;
import org.usfirst.frc.team2129.robot.subsystems.LifterSubsystem;
import org.usfirst.frc.team2129.robot.subsystems.LogSubsystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	public static final LogSubsystem kLogSubsystem
			= new LogSubsystem();
	private OI m_OI;
	private DriveTrainSubsystem m_DriveSubsystem;
	private LifterSubsystem m_lifterSubsystem;
	

	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		m_OI = new OI();
		m_DriveSubsystem = new DriveTrainSubsystem(m_OI);
		m_lifterSubsystem = new LifterSubsystem(m_OI);
		
		m_OI.initialize(m_lifterSubsystem);
		
		SwLogger.info("entering robotInit");
		m_chooser.addDefault("Drive Command", new CanDriveCommand(m_DriveSubsystem));
		m_chooser.addObject("Lifter Command", new RaiseLifter(m_lifterSubsystem, m_OI));
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", m_chooser);
		SwLogger.info("exiting robotInit");
	
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
		/*
		SwLogger.info("entering disabledInit");
		SwLogger.info("exiting disabledInit");
		*/
	}

	@Override
	public void disabledPeriodic() {
//		SwLogger.info("entering disabledPeriodic");
//		Scheduler.getInstance().run();
//		SwLogger.info("exiting disabledPeriotic");
		
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		SwLogger.info("entering autonomousInit");
		m_autonomousCommand = m_chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
		SwLogger.info("exiting autonomousInit");
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
	//	SwLogger.info("entering autonomousPeriodic");
	//	Scheduler.getInstance().run();
	//	SwLogger.info("exiting autonomousPeriodic");
	}

	@Override
	public void teleopInit() {
		SwLogger.info("entering teleopInit");
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
		SwLogger.info("exiting teleopInit");
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		//SwLogger.info("entering teleopPeriodic");
		Scheduler.getInstance().run();
		//SwLogger.info("exiting teleopPeriodic");
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
		//SwLogger.info("entering testPeriodic");
		//SwLogger.info("exiting testPeriodic");
	}
}
