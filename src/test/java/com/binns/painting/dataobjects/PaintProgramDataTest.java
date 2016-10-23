package com.binns.painting.dataobjects;

import static org.junit.Assert.*;

import org.junit.Test;

public class PaintProgramDataTest {

	@Test
	public void testCreateNewCanvas(){
		PaintProgramData programData = new PaintProgramData();
		
		programData.createNewCanvas(10, 15);
		
		Canvas canvas = programData.getCanvas();
		
		assertEquals(10, canvas.getWidth());
		assertEquals(15, canvas.getHeight());
		
	}
	
	@Test
	public void testDefaultCanvas(){
		PaintProgramData programData = new PaintProgramData();
				
		Canvas canvas = programData.getCanvas();
		
		assertEquals(1, canvas.getWidth());
		assertEquals(1, canvas.getHeight());
		
	}
	
}
