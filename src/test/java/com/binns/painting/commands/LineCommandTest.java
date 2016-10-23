package com.binns.painting.commands;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.awt.Point;

import org.junit.Test;
import org.mockito.internal.util.reflection.Whitebox;

import com.binns.painting.dataobjects.Canvas;
import com.binns.painting.dataobjects.PaintProgramData;

public class LineCommandTest {
	
	@Test
	public void testIsValid_verticalLine(){
	
		PaintProgramData data = new PaintProgramData();
		data.createNewCanvas(10, 10);
		
		Command lineCommand = LineCommand.create(new Point(1,1), new Point(1, 6));
		
		assertTrue(lineCommand.isValid(data));
	}
	
	@Test
	public void testIsValid_horizontalLine(){
	
		PaintProgramData data = new PaintProgramData();
		data.createNewCanvas(10, 10);
		
		Command lineCommand = LineCommand.create(new Point(1,6), new Point(6, 6));
		
		assertTrue(lineCommand.isValid(data));
	}
	
	@Test
	public void testIsValid_notAStraightLine(){
	
		PaintProgramData data = new PaintProgramData();
		data.createNewCanvas(10, 10);
		
		Command lineCommand = LineCommand.create(new Point(1,6), new Point(6, 5));
		
		assertFalse(lineCommand.isValid(data));
	}

	@Test
	public void testIsValid_lineOutOfBounds1(){
	
		PaintProgramData data = new PaintProgramData();
		data.createNewCanvas(10, 10);
		
		Command lineCommand = LineCommand.create(new Point(1,6), new Point(1, 15));
		
		assertFalse(lineCommand.isValid(data));
	}
	
	@Test
	public void testIsValid_lineOutOfBounds2(){
	
		PaintProgramData data = new PaintProgramData();
		data.createNewCanvas(10, 10);
		
		Command lineCommand = LineCommand.create(new Point(1,6), new Point(11, 6));
		
		assertFalse(lineCommand.isValid(data));
	}
	
	@Test
	public void testProcess_valid(){
		PaintProgramData data = new PaintProgramData();
		Canvas canvas = mock(Canvas.class);
		Whitebox.setInternalState(data, "canvas", canvas);
		
		Point start = new Point(1,1);
		Point end = new Point(1, 4);
		
		when(canvas.isPointInCanvas(start)).thenReturn(true);
		when(canvas.isPointInCanvas(end)).thenReturn(true);
		
		Command command = LineCommand.create(start, end);
		
		command.process(data);
		
		verify(canvas).drawLine(start, end);
	}
	
	@Test
	public void testProcess_invalid(){
		PaintProgramData data = new PaintProgramData();
		Canvas canvas = mock(Canvas.class);
		
		Point start = new Point(1,1);
		Point end = new Point(1, 4);
		
		Command command = LineCommand.create(start, end);
		
		command.process(data);
		
		verify(canvas, never()).drawLine(start, end);
	}

}
