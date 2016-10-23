package com.binns.painting.dataobjects;

/**
 * Simple data object that stores the current state of the program.
 * 
 * @author Kyle Binns
 *
 */
public class PaintProgramData {

	private Canvas canvas = new Canvas(1,1);
	
	public void createNewCanvas(int width, int height) {
		canvas = new Canvas(width, height);		
	}

	public Canvas getCanvas() {
		return canvas;
	}

}
