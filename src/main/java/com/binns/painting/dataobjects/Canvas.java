package com.binns.painting.dataobjects;

import java.awt.Point;
import java.util.Arrays;

/**
 * This component holds and maintains the active state
 * of the drawing canvas.
 * 
 * @author Kyle Binns
 *
 */
public class Canvas {

	public static final char HORIZONTAL_BORDER = '-';
	public static final char VERTICAL_BORDER = '|';
	public static final char DEFAULT_EMPTY = ' ';
	public static final char DEFAULT_LINE_CHARACTER = 'x';
	
	private CanvasRenderer renderer;
	private char[][] grid;
	
	public Canvas(int width, int height) {
		grid = new char[height][width];
		renderer = new CanvasRenderer();
		zeroOutGrid(grid);
	}
	
	private void zeroOutGrid(char[][] grid){
		for (char[] rowData : grid) { 
			Arrays.fill(rowData, DEFAULT_EMPTY);
		}
	}
	
	public int getHeight(){
		return grid.length;
	}
	
	public int getWidth(){
		return grid[0].length;
	}
	
	char[][] getGrid(){
		return grid;
	}
	
	public boolean isPointInCanvas(Point p){
		int canvasWidth = getWidth();
		int canvasHeight = getHeight();
		
		return p.x < canvasWidth + 1 && p.y < canvasHeight + 1;
	}
	
	public void drawLine(Point start, Point end){
		if(start.y == end.y){
			drawHorizontalLine(start, end);
		
		} else {
			drawVerticalLine(start, end);
		}
		
	}
	
	private void drawHorizontalLine(Point start, Point end){
		char[] row = grid[start.y - 1];
		
		for(int i = start.x - 1; i < end.x; i++){
			row[i] = DEFAULT_LINE_CHARACTER;
		}
	}
	
	private void drawVerticalLine(Point start, Point end){
		for(int i = start.y - 1; i < end.y; i++){
			char[] row = grid[i];
			row[start.x - 1] = DEFAULT_LINE_CHARACTER;
		}		
	}
	
	public void drawRectangle(Point topLeft, Point topRight, Point bottomLeft, Point bottomRight){		
		drawLine(topLeft, topRight);
		drawLine(topLeft, bottomLeft);
		drawLine(bottomLeft, bottomRight);
		drawLine(topRight, bottomRight);
	}
	
	public void bucketFill(Point point, char color){
	
		if(drawPointForBucketFill(point, color)){
			bucketFill(new Point(point.x, point.y+1), color); // up
			bucketFill(new Point(point.x, point.y-1), color); // down
			bucketFill(new Point(point.x-1, point.y), color); // left
			bucketFill(new Point(point.x+1, point.y), color); // right
		}

	}
	
	private boolean drawPointForBucketFill(Point point, char color) {
		try {
			if(grid[point.y - 1][point.x -1] == ' '){
				grid[point.y - 1][point.x -1] = color;
				return true;
			}
			
			return false;
		}catch(IndexOutOfBoundsException e){
			return false;
		}
		
	}

	public StringBuffer renderCanvas(){
		return renderer.renderCanvas(this);
	}
}
