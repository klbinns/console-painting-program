package com.binns.painting.commands;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

import com.binns.painting.dataobjects.PaintProgramData;

public class RectangleCommand extends GenericCommand {

	public static final String REGEX_COMMAND = "(r|R) (\\d+) (\\d+) (\\d+) (\\d+)"; 
	
	private List<Command> lineCommands = new LinkedList<>();
	
	private RectangleCommand(Point topLeft, Point bottomRight){		
		Point bottomLeft = new Point(topLeft.x, bottomRight.y);
		Point topRight = new Point(bottomRight.x, topLeft.y);
		
		lineCommands.add(LineCommand.create(topLeft, topRight));
		lineCommands.add(LineCommand.create(topLeft, bottomLeft));
		lineCommands.add(LineCommand.create(bottomLeft, bottomRight));
		lineCommands.add(LineCommand.create(topRight, bottomRight));
	}
		
	public static Command create(String command){
		
		int x1 = 0;
		int y1 = 0;
		int x2 = 0;
		int y2 = 0;
		
		List<String> parsedElements = GenericCommand.parseCommand(command, REGEX_COMMAND);
		
		if(parsedElements.size() == 4){
			x1 = Integer.parseInt(parsedElements.get(0));
			y1 = Integer.parseInt(parsedElements.get(1));
			x2 = Integer.parseInt(parsedElements.get(2));
			y2 = Integer.parseInt(parsedElements.get(3));
		}
		
		return new RectangleCommand(new Point(x1, y1), new Point(x2, y2));
	}
	
	public boolean isValid(PaintProgramData data) {
		
		for(Command lineCommand : lineCommands) {
			if(!lineCommand.isValid(data)){
				return false;
			}
		}
		
		return true;
	}

		
	public void process(PaintProgramData data) {
		if(isValid(data)){
			for(Command lineCommand : lineCommands) {
				lineCommand.process(data);
			}
		}
	}

}
