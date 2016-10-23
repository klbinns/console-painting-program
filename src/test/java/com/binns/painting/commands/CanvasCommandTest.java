package com.binns.painting.commands;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.mockito.internal.util.reflection.Whitebox;

import com.binns.painting.dataobjects.PaintProgramData;

public class CanvasCommandTest {

	@Test
	public void testMatch_c(){
		String testInput = "c";
		assertFalse(GenericCommand.match(testInput, CanvasCommand.REGEX_COMMAND));	
	}
	
	@Test
	public void testMatch_C(){
		String testInput = "C";
		assertFalse(GenericCommand.match(testInput, CanvasCommand.REGEX_COMMAND));	
	}
	
	@Test
	public void testMatch_emptyString(){
		String testInput = " ";
		assertFalse(GenericCommand.match(testInput, CanvasCommand.REGEX_COMMAND));	
	}
	
	@Test
	public void testMatch_null(){
		String testInput = null;
		assertFalse(GenericCommand.match(testInput, CanvasCommand.REGEX_COMMAND));	
	}
	
	@Test
	public void testMatch_c_plus_int_args(){
		String testInput = "c 10 20";
		assertTrue(GenericCommand.match(testInput, CanvasCommand.REGEX_COMMAND));	
	}
	
	@Test
	public void testMatch_c_plus_too_many_int_args(){
		String testInput = "c 10 20 20";
		assertFalse(GenericCommand.match(testInput, CanvasCommand.REGEX_COMMAND));	
	}
	
	@Test
	public void testMatch_c_plus_negative_int_args(){
		String testInput = "c 10 -20";
		assertFalse(GenericCommand.match(testInput, CanvasCommand.REGEX_COMMAND));	
	}
	
	@Test
	public void testMatch_c_plus_string_args(){
		String testInput = "c hi hello";
		assertFalse(GenericCommand.match(testInput, CanvasCommand.REGEX_COMMAND));	
	}

	@Test
	public void testCreateCanvasCommand(){
		Command command = CanvasCommand.create("c 10 20");
		assertNotNull(command);

		int width = (int)Whitebox.getInternalState(command, "width");
		int height = (int)Whitebox.getInternalState(command, "height");
		
		assertEquals(10, width);
		assertEquals(20, height);
	}
	
	@Test
	public void testIsValid_true(){
		Command command = CanvasCommand.create("c 10 10");
		assertTrue(command.isValid(null));
	}
	
	@Test
	public void testIsValid_false(){
		Command command = CanvasCommand.create("c 0 0");
		assertFalse(command.isValid(null));
	}
	
	@Test
	public void testIsValid_false_y_axis(){
		Command command = CanvasCommand.create("c 10 0");
		assertFalse(command.isValid(null));
	}
	
	@Test
	public void testIsValid_false_x_axis(){
		Command command = CanvasCommand.create("c 0 10");
		assertFalse(command.isValid(null));
	}
	
	@Test
	public void testProcess_valid(){
		PaintProgramData data = mock(PaintProgramData.class);
		Command command = CanvasCommand.create("c 10 10");
		
		command.process(data);
		
		verify(data).createNewCanvas(10, 10);
	}
	
	@Test
	public void testProcess_invalid(){
		PaintProgramData data = mock(PaintProgramData.class);
		Command command = CanvasCommand.create("c 0 0");
		
		command.process(data);
		verify(data, never()).createNewCanvas(0, 0);
	}
	
	
}
