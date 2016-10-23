package com.binns.painting.commands;

import static org.junit.Assert.*;

import org.junit.Test;

public class CommandInterpreterTest {

	@Test
	public void testQuitCommandReturn_q(){
		Command command = CommandInterpreter.interpret("q");
		assertTrue(command instanceof QuitCommand);
	}
	
	@Test
	public void testQuitCommandReturn_Q(){
		Command command = CommandInterpreter.interpret("Q");
		assertTrue(command instanceof QuitCommand);
	}
	
	@Test
	public void testQuitCanvasReturn_c(){
		Command command = CommandInterpreter.interpret("c 10 10");
		assertTrue(command instanceof CanvasCommand);
	}
	
	@Test
	public void testQuitCanvasReturn_C(){
		Command command = CommandInterpreter.interpret("C 5 8");
		assertTrue(command instanceof CanvasCommand);
	}
	
	@Test
	public void testLineCommandReturn_l(){
		Command command = CommandInterpreter.interpret("l 5 8 5 10");
		assertTrue(command instanceof LineCommand);
	}
	
	@Test
	public void testLineCommandReturn_L(){
		Command command = CommandInterpreter.interpret("L 5 8 5 10");
		assertTrue(command instanceof LineCommand);
	}
	
	@Test
	public void testRectangleCommandReturn_r(){
		Command command = CommandInterpreter.interpret("r 5 8 5 10");
		assertTrue(command instanceof RectangleCommand);
	}
	
	@Test
	public void testRectangleCommandReturn_R(){
		Command command = CommandInterpreter.interpret("R 5 8 5 10");
		assertTrue(command instanceof RectangleCommand);
	}
	
	@Test
	public void testBucketFillCommandReturn_b(){
		Command command = CommandInterpreter.interpret("b 5 8 b");
		assertTrue(command instanceof BucketFillCommand);
	}
	
	@Test
	public void testBucketFillCommandReturn_B(){
		Command command = CommandInterpreter.interpret("B 5 8 s");
		assertTrue(command instanceof BucketFillCommand);
	}
	
	@Test
	public void testInvalidCommandReturn(){
		Command command = CommandInterpreter.interpret("Rdls");
		assertTrue(command instanceof InvalidCommand);
	}
	
}
