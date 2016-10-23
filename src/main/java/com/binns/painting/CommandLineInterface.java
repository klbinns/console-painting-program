package com.binns.painting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 * The component that is responsibile for handling user input and output.
 * Accepts commands from the user and displays output.
 * 
 * @author Kyle Binns
 *
 */
public class CommandLineInterface {
	
	private InputStream inputStream;
	private PrintStream outputStream;
	
	public CommandLineInterface(InputStream inputStream, PrintStream outputStream){
		this.inputStream = inputStream;
		this.outputStream = outputStream;	
	}
		
	String readInputFromCommandLine(){
		
		String input;
		
		try {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
			input = br.readLine().trim();

		} catch (IOException e) {
			input = " ";
		}
		
		return input;
	}

	void printCommand(String command){
		outputStream.print(command);
	}

	void printCanvas(StringBuffer buildCanvas) {
		outputStream.print(buildCanvas.toString());
	}
	
	void printNewLine(){
		outputStream.println();
	}
	
}
