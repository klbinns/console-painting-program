package com.binns.painting.commands;

import com.binns.painting.dataobjects.PaintProgramData;

public class InvalidCommand extends GenericCommand {

	private InvalidCommand(){
		
	}
	
	public static Command create(){
		return new InvalidCommand();
	}
	
	public boolean isValid(PaintProgramData data) {
		return false;
	}

	
	public void process(PaintProgramData data) {
		// No operation. An invalid command does nothing when processed.
	}

}
