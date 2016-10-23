package com.binns.painting.commands;

import static org.junit.Assert.*;

import org.junit.Test;

public class InvalidCommandTest {
	
	@Test
	public void testCreateQuitCommand(){
		Command command = InvalidCommand.create();
		assertNotNull(command);
		assertTrue(command instanceof InvalidCommand);
	}
	
	@Test
	public void testIsValid(){
		Command command = InvalidCommand.create();
		assertFalse(command.isValid(null));
	}
	
}
