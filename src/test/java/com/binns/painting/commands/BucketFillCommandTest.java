package com.binns.painting.commands;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.spy;

import org.junit.Test;

import com.binns.painting.dataobjects.PaintProgramData;

public class BucketFillCommandTest {
	
	@Test
	public void testIsValid_true(){
	
		PaintProgramData data = new PaintProgramData();
		data.createNewCanvas(10, 10);
		
		Command command = BucketFillCommand.create("b 2 2 c");
		
		assertTrue(command.isValid(data));
	}
	
	@Test
	public void testIsValid_false(){
	
		PaintProgramData data = new PaintProgramData();
		data.createNewCanvas(10, 10);
		
		Command command = BucketFillCommand.create("b 20 20 c");
		
		assertFalse(command.isValid(data));
	}
		
	@Test
	public void testProcess_valid(){
		PaintProgramData data = new PaintProgramData();
		data.createNewCanvas(10, 10);
				
		Command command = BucketFillCommand.create("b 1 1 d");
		
		command.process(data);
	}
	
	@Test
	public void testProcess_invalid(){
		PaintProgramData data = spy(PaintProgramData.class);
		data.createNewCanvas(10, 10);
		
		Command command = BucketFillCommand.create("b 20 20 c");
		
		command.process(data);
	}

}
