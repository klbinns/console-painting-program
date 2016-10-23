package com.binns.painting.commands;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.binns.painting.dataobjects.Canvas;

/**
 * An abstract Command object. Provides useful utility methods
 * that child Command objects can use.
 * 
 * @author Kyle Binns
 *
 */
public abstract class GenericCommand implements Command {

	protected static boolean match(String commandString, String commandRegexFormat){
		if(commandString != null){
			return commandString.matches(commandRegexFormat);
		} else {
			return false;
		}
	}
	
	protected static List<String> parseCommand(String commandInput, String commandRegexFormat){
		
		Pattern pattern = Pattern.compile(commandRegexFormat);
		Matcher match = pattern.matcher(commandInput);

		List<String> parsedElements = new ArrayList<>();
		
		if (match.find()){
			for(int i = 2; i < match.groupCount() + 1; i++){
				parsedElements.add(match.group(i));
			}
		}
		
		return parsedElements;
	}
	
	protected boolean confirmPointsAreFullyInCanvas(Canvas canvas, Point... points) {
		
		for(Point p : points){
			if(!canvas.isPointInCanvas(p)){
				return false;
			}
		}
		return true;
	}

}
