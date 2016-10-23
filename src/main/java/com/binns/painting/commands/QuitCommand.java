package com.binns.painting.commands;

import com.binns.painting.dataobjects.PaintProgramData;

public class QuitCommand extends GenericCommand {

	public static final String REGEX_COMMAND = "q|Q"; 
	
	private QuitCommand(){
		
	}
	
	public static Command create(String command){
		return new QuitCommand();
	}
	
	
	public boolean isValid(PaintProgramData data){
		return true;
	}
	
	public void process(PaintProgramData data){
		System.exit(0);
	}
		
}
