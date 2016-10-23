package com.binns.painting.dataobjects;

/**
 * This component is responsible for translating the Canvas object
 * into a rendered StringBuffer that can be sent to the output stream
 * for user viewing.
 *  
 * @author Kyle Binns
 *
 */
public class CanvasRenderer {

	public StringBuffer renderCanvas(Canvas canvas){
		
		StringBuffer stringBuffer = new StringBuffer();
		char[][] grid = canvas.getGrid();
		
		printHorizontalBorder(stringBuffer, canvas.getWidth());
		
		printRows(stringBuffer, grid);
		
		printHorizontalBorder(stringBuffer, canvas.getWidth());
		
		return stringBuffer;
	}

	private StringBuffer printRows(StringBuffer stringBuffer, char[][] grid){
		for(char[] rowData : grid) {
			printRow(stringBuffer, rowData);
		}
		
		return stringBuffer;
	}
	
	private StringBuffer printRow(StringBuffer stringBuffer, char[] rowData){
		printVericalBorder(stringBuffer);
		
		for(char c : rowData){
			stringBuffer.append(c);
		}
		
		printVericalBorder(stringBuffer);
		stringBuffer.append("\n");
		return stringBuffer;
	}
	
	private StringBuffer printHorizontalBorder(StringBuffer stringBuffer, int width) {
		stringBuffer.append(' ');
		
		for(int i = 0; i < width; i++){
			stringBuffer.append(Canvas.HORIZONTAL_BORDER);
		}
		
		stringBuffer.append("\n");
		return stringBuffer;
	}
	
	private StringBuffer printVericalBorder(StringBuffer stringBuffer) {
		stringBuffer.append(Canvas.VERTICAL_BORDER);
		return stringBuffer;
	}

}

