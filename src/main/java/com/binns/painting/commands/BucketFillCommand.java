package com.binns.painting.commands;

import java.awt.Point;
import java.util.List;

import com.binns.painting.dataobjects.Canvas;
import com.binns.painting.dataobjects.PaintProgramData;

public class BucketFillCommand extends GenericCommand {

	public static final String REGEX_COMMAND = "(b|B) (\\d+) (\\d+) ([a-zA-Z])"; 
	
	private Point start;
	char color;
	
	private BucketFillCommand(Point point, char color){
		this.start = point;
		this.color = color;
	}
	
	public static Command create(String command){

		int x1 = 0;
		int y1 = 0;
		char color = Canvas.DEFAULT_LINE_CHARACTER;
		
		List<String> parsedElements = GenericCommand.parseCommand(command, REGEX_COMMAND);
		
		if(parsedElements.size() == 3){
			x1 = Integer.parseInt(parsedElements.get(0));
			y1 = Integer.parseInt(parsedElements.get(1));
			color = parsedElements.get(2).charAt(0);
		}
		
		return new BucketFillCommand(new Point(x1, y1), color);
	}
	
	public boolean isValid(PaintProgramData data) {
		Canvas canvas = data.getCanvas();
		return confirmPointsAreFullyInCanvas(canvas, start);		
	}
		
	public void process(PaintProgramData data) {
		if(isValid(data)){
			Canvas canvas = data.getCanvas();
			canvas.bucketFill(start, color);
		}
	}

}
