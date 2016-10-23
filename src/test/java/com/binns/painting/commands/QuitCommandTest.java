package com.binns.painting.commands;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class QuitCommandTest {

	@Test
	public void testMatch_q(){
		String testInput = "q";
		assertTrue(GenericCommand.match(testInput, QuitCommand.REGEX_COMMAND));	
	}
	
	@Test
	public void testMatch_Q(){
		String testInput = "Q";
		assertTrue(GenericCommand.match(testInput, QuitCommand.REGEX_COMMAND));	
	}
	
	@Test
	public void testMatch_emptyString(){
		String testInput = " ";
		assertFalse(GenericCommand.match(testInput, QuitCommand.REGEX_COMMAND));	
	}
	
	@Test
	public void testMatch_qPlusMore(){
		String testInput = "q args here";
		assertFalse(GenericCommand.match(testInput, QuitCommand.REGEX_COMMAND));	
	}
	
	@Test
	public void testMatch_null(){
		String testInput = null;
		assertFalse(GenericCommand.match(testInput, QuitCommand.REGEX_COMMAND));	
	}
	
	@Test
	public void testCreateQuitCommand(){
		Command command = QuitCommand.create(null);
		assertNotNull(command);
		assertTrue(command instanceof QuitCommand);
	}
	
	@Test
	public void testIsValid(){
		Command command = QuitCommand.create(null);
		assertTrue(command.isValid(null));
	}
	
}
