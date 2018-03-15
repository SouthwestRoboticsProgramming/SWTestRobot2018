package org.usfirst.frc.team2129.robot;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SwLogger {
	public SwLogger() {
	}
	
	public static void info(String msg) {
		Logger log = Logger.getLogger("SwLogger");
		log.log(Level.INFO, msg);
	}
}
