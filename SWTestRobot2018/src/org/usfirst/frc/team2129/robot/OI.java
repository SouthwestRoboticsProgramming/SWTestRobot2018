/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2129.robot;

import org.usfirst.frc.team2129.robot.commands.CanDriveCommand;
import org.usfirst.frc.team2129.robot.commands.DriveForwardCommand;
import org.usfirst.frc.team2129.robot.commands.FirstDriveCommand;
import org.usfirst.frc.team2129.robot.commands.LogCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a command in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	private XboxController xbox;

	private FirstDriveCommand m_drive;
	
	private static final int PORT = 0;
	public enum XboxAxisMap {
		leftX(0),
		leftY(1);
		private int num;
		XboxAxisMap(int a) {
			num = a;
		}
		public int toInt() {
			return num;
		}
	}
	
	public enum XboxButtonMap{
		A(1),
		B(2),
		X(3),
		Y(4),
		LeftTrigger(5),
		RightTrigger(6),
		Windows(7),
		Select(8),
		LeftJoystick(9),
		RightJoystick(10);
		
		private int num;
		XboxButtonMap(int buttonNumber)
		{
			num = buttonNumber;
		}
		
		public int toInt()
		{
			return num;
		}
	}
	
	public OI()
	{
		xbox = new XboxController(PORT);
		
		Button a = new JoystickButton(xbox, XboxButtonMap.A.toInt());
//		a.whenPressed(new LogCommand(PORT, LogCommand.LogWhat.Pressed, "A"));
		a.whenPressed(new DriveForwardCommand());
		
	
	//	m_drive = new FirstDriveCommand(5, 6, new Joystick(PORT), XboxAxisMap.leftX.toInt(), XboxAxisMap.leftY.toInt());
	}
	
	public void drive()
	{
		//m_drive.start();
	}
	
	public Joystick getJoystick()
	{
		return new Joystick(PORT);
	}
	
	public int getDriveXAxis()
	{
		return XboxAxisMap.leftX.toInt();
	}
	
	public int getDriveYAxis()
	{
		return XboxAxisMap.leftY.toInt();
	}
}
