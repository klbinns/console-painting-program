package com.binns.painting.commands;

import java.util.List;

import com.binns.painting.dataobjects.PaintProgramData;

public class CanvasCommand extends GenericCommand {

	public static final String REGEX_COMMAND = "(c|C) (\\d+) (\\d+)"; 
	
	private int width;
	private int height;
	
	private CanvasCommand(int width, int height){
		this.width = width;
		this.height = height;
	}
	
	public static Command create(String command){

		int width = 0;
		int height = 0;
		
		List<String> parsedElements = GenericCommand.parseCommand(command, REGEX_COMMAND);
		
		if(parsedElements.size() == 2){
			width = Integer.parseInt(parsedElements.get(0));
			height = Integer.parseInt(parsedElements.get(1));
		}
		
		return new CanvasCommand(width, height);
	}
	
	public boolean isValid(PaintProgramData data){
		return width > 0 && height > 0;
	}

	public void process(PaintProgramData data){
		if(isValid(data)){
			data.createNewCanvas(width, height);
		}
	}
	
}
