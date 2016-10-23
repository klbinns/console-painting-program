package com.binns.painting.dataobjects;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

public class CanvasRendererTest {

	@Test
	public void testTopBorder(){
		Canvas canvas = new Canvas(10, 10);
		
		CanvasRenderer renderer = new CanvasRenderer();
		StringBuffer sb = renderer.renderCanvas(canvas);
		
		assertEquals(" ----------\n|", sb.subSequence(0, 13));
	}
	
	@Test
	public void testHorizontalLine(){
		Canvas canvas = new Canvas(10, 10);
		canvas.drawLine(new Point(1,1), new Point(4, 1));
		
		CanvasRenderer renderer = new CanvasRenderer();
		StringBuffer sb = renderer.renderCanvas(canvas);
		
		assertEquals(" ----------\n", sb.subSequence(0, 12));
		assertEquals("|xxxx      |\n", sb.subSequence(12, 25));
	}
	
}
