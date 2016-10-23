package com.binns.painting;

import com.binns.painting.commands.Command;
import com.binns.painting.commands.CommandInterpreter;
import com.binns.painting.dataobjects.Canvas;
import com.binns.painting.dataobjects.PaintProgramData;

/**
 * The main control component of the program.
 * 
 * @author Kyle Binns
 *
 */
public class PaintingProgram {

	private CommandLineInterface cli;
	private PaintProgramData data;
	
	public PaintingProgram() {
		cli = new CommandLineInterface(System.in, System.out);
		data = new PaintProgramData();
	}
	
	public void start() {
		
		while(true) {
			
			promptForCommand();
			
			String userInput = readInput();
			
			Command command = interpretCommand(userInput);
			
			processCommand(command);
		
		}
		
	}
	
	void processCommand(Command command){
		if(command.isValid(data)){
			
			command.process(data);
			printCanvas(data.getCanvas());
		
		} else {
			
			promptInvalidCommand();
		}
	}
	
	void promptForCommand(){
		cli.printCommand("Enter command: ");
	}
	
	void promptInvalidCommand(){
		cli.printCommand("Invalid command. Please try again.");
		cli.printNewLine();
	}
		
	void printCanvas(Canvas canvas){
		cli.printNewLine();
		cli.printCanvas(canvas.renderCanvas());
		cli.printNewLine();
	}
	
	String readInput() {
		return cli.readInputFromCommandLine();
	}
	
	Command interpretCommand(String userInput) {	
		return CommandInterpreter.interpret(userInput);
	}
	
	/**
	 * Entry point into the program
	 * @param args none required
	 */
	public static void main(String[] args) {
		new PaintingProgram().start();
	}
}
