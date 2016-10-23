package com.binns.painting.commands;

/**
 * This component interprets the raw user input and translates
 * it into a Command object which can be used by the system.
 * 
 * If the user inputs an invalid command, this component returns
 * an InvalidCommand object, which by default, does nothing when processed.
 * 
 * @author Kyle Binns
 *
 */
public class CommandInterpreter {

	public static Command interpret(String commandString){
		
		Command command;
		
		if(GenericCommand.match(commandString, QuitCommand.REGEX_COMMAND)){
			
			command = QuitCommand.create(commandString);
		
		} else if(GenericCommand.match(commandString, CanvasCommand.REGEX_COMMAND)) {
			
			command = CanvasCommand.create(commandString);
			
		} else if(GenericCommand.match(commandString, LineCommand.REGEX_COMMAND)) {
			
			command = LineCommand.create(commandString);
			
		} else if(GenericCommand.match(commandString, RectangleCommand.REGEX_COMMAND)) {
			
			command = RectangleCommand.create(commandString);
			
		} else if(GenericCommand.match(commandString, BucketFillCommand.REGEX_COMMAND)) {
			
			command = BucketFillCommand.create(commandString);
			
		} else {
			
			command = InvalidCommand.create();
			
		}
		
		return command;
	}

}
