package com.binns.painting.dataobjects;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.awt.Point;

import org.junit.Test;
import org.mockito.internal.util.reflection.Whitebox;

public class CanvasTest {

	@Test
	public void testGetGrid(){
		Canvas canvas = new Canvas(10, 5);
		
		char[][] grid = canvas.getGrid();
		
		assertEquals(10, grid[0].length);
		assertEquals(5, grid.length);
	}
	
	
	@Test
	public void testDrawLine_vertical(){
		Canvas canvas = new Canvas(10, 10);
		
		canvas.drawLine(new Point(1, 2), new Point(1, 4));
		
		char[][] grid = canvas.getGrid();
		
		assertEquals(' ', grid[0][0]);
		assertEquals('x', grid[1][0]);
		assertEquals('x', grid[2][0]);
		assertEquals('x', grid[3][0]);
		assertEquals(' ', grid[4][0]);		
	}
	
	@Test
	public void testDrawLine_horizontal(){
		Canvas canvas = new Canvas(10, 10);
		
		canvas.drawLine(new Point(3, 2), new Point(6, 2));
		
		char[][] grid = canvas.getGrid();
		
		assertEquals(' ', grid[1][1]);
		assertEquals('x', grid[1][2]);
		assertEquals('x', grid[1][3]);
		assertEquals('x', grid[1][4]);
		assertEquals('x', grid[1][5]);
		assertEquals(' ', grid[1][6]);	
	}
	
	
	
	@Test
	public void testRenderCanvas(){
		Canvas canvas = new Canvas(10, 5);
		CanvasRenderer renderer = mock(CanvasRenderer.class);
		Whitebox.setInternalState(canvas, "renderer", renderer);
		
		canvas.renderCanvas();
		
		verify(renderer).renderCanvas(canvas);
	}
	
	
}
