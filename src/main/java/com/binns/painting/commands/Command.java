package com.binns.painting.commands;

import com.binns.painting.dataobjects.PaintProgramData;

/**
 * The Command interface. All commands should implement this interface.
 * 
 * @author Kyle Binns
 *
 */
public interface Command {

	/**
	 * This method checks to see if the command can be successfully
	 * processed within the current state of the program.
	 * 
	 * If will return false if, for example, the user wants
	 * to draw a line that extends outside the canvas area.
	 * 
	 * @param data data containing the current state of the program
	 * @return true if is a valid command, false otherwise.
	 */
	public boolean isValid(PaintProgramData data);
	
	/**
	 * Processes the command and updates the program data
	 * 
	 * @param data
	 */
	public void process(PaintProgramData data);
	
}
