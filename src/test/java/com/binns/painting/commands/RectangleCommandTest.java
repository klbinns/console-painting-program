package com.binns.painting.commands;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.binns.painting.dataobjects.PaintProgramData;

public class RectangleCommandTest {
	
	@Test
	public void testIsValid_true(){
	
		PaintProgramData data = new PaintProgramData();
		data.createNewCanvas(10, 10);
		
		Command command = RectangleCommand.create("r 2 2 5 5");
		
		assertTrue(command.isValid(data));
	}
	
	@Test
	public void testIsValid_outOfBounds(){
	
		PaintProgramData data = new PaintProgramData();
		data.createNewCanvas(10, 10);
		
		Command command = RectangleCommand.create("r 2 2 11 11");
		
		assertFalse(command.isValid(data));
	}
	
}
