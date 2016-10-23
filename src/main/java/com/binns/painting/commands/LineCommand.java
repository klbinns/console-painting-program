package com.binns.painting.commands;

import java.awt.Point;
import java.util.List;

import com.binns.painting.dataobjects.Canvas;
import com.binns.painting.dataobjects.PaintProgramData;

public class LineCommand extends GenericCommand {

	public static final String REGEX_COMMAND = "(l|L) (\\d+) (\\d+) (\\d+) (\\d+)"; 
	
	private Point start;
	private Point end;
	
	private LineCommand(Point point1, Point point2){
		this.start = point1;
		this.end = point2;
	}
		
	public static Command create(Point start, Point end){
		return new LineCommand(start, end);
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
		
		return new LineCommand(new Point(x1, y1), new Point(x2, y2));
	}
	
	public boolean isValid(PaintProgramData data) {
		Canvas canvas = data.getCanvas();
		
		return confirmHorizontalOrVerticalLine(start, end) &&
				confirmPointsAreFullyInCanvas(canvas, start, end);		
	}

	boolean confirmHorizontalOrVerticalLine(Point start, Point end) {
		return confirmHoriztonalLine(start, end) || confirmVerticalLine(start, end);
	}

	private boolean confirmVerticalLine(Point start, Point end) {
		return start.x == end.x;
	}

	private boolean confirmHoriztonalLine(Point start, Point end) {
		return start.y == end.y;
	}
		
	public void process(PaintProgramData data) {
		if(isValid(data)){
			Canvas canvas = data.getCanvas();
			canvas.drawLine(start, end);
		}
	}

}
