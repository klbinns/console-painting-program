package com.binns.painting;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.PrintStream;

import org.junit.Test;

public class CommandLineInterfaceTest {

	@Test
	public void testPrintCommand(){
		PrintStream p = mock(PrintStream.class);
		
		CommandLineInterface cli = new CommandLineInterface(null, p);
		cli.printCommand("Enter command: ");
		
		verify(p).print("Enter command: ");
	}
	
	@Test
	public void testPrintCanvas(){
		PrintStream p = mock(PrintStream.class);
		StringBuffer buffer = new StringBuffer();
		buffer.append("hello");
		
		CommandLineInterface cli = new CommandLineInterface(null, p);
		cli.printCanvas(buffer);
		
		verify(p).print("hello");	
	}
	
	@Test
	public void testPrintNewLine(){
		PrintStream p = mock(PrintStream.class);
		
		CommandLineInterface cli = new CommandLineInterface(null, p);
		cli.printNewLine();
		
		verify(p).println();	
	}
}
