package com.binns.painting;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.mockito.internal.util.reflection.Whitebox;

import com.binns.painting.dataobjects.Canvas;

public class PaintingProgramTest {
	
	@Test
	public void testPromptForCommand(){
		CommandLineInterface cli = mock(CommandLineInterface.class);
		
		PaintingProgram program = new PaintingProgram();
		Whitebox.setInternalState(program, "cli", cli);
		
		program.promptForCommand();
		
		verify(cli).printCommand("Enter command: ");
	}
	
	@Test
	public void testPromptInvalidCommand(){
		CommandLineInterface cli = mock(CommandLineInterface.class);
		
		PaintingProgram program = new PaintingProgram();
		Whitebox.setInternalState(program, "cli", cli);
		
		program.promptInvalidCommand();
		
		verify(cli).printCommand("Invalid command. Please try again.");
		verify(cli).printNewLine();
	}
	
	@Test
	public void testPrintCanvas(){
		CommandLineInterface cli = mock(CommandLineInterface.class);
		Canvas mockCanvas = mock(Canvas.class);
		
		PaintingProgram program = new PaintingProgram();
		Whitebox.setInternalState(program, "cli", cli);
		
		program.printCanvas(mockCanvas);
		
		verify(cli, times(2)).printNewLine();
		verify(cli).printCanvas(mockCanvas.renderCanvas());
	}
	
	@Test
	public void testReadInput(){
		CommandLineInterface cli = mock(CommandLineInterface.class);
		
		PaintingProgram program = new PaintingProgram();
		Whitebox.setInternalState(program, "cli", cli);
		
		program.readInput();
		
		verify(cli).readInputFromCommandLine();
	}
	
}
