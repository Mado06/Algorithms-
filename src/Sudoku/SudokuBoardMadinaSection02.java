package Sudoku;

public class SudokuBoardMadinaSection02 {

	
   private int [] boardCells;
   int boxHeights;
   int boxWidth;
   private int boardSize;
    int value;
	private int arrCounter;
 
	public  SudokuBoardMadinaSection02 (int heights, int width) {
		
		this.boxWidth = width;
		this.boxHeights = heights;
		boardSize =  boxHeights * boxWidth;
		boardCells = new  int [(boxHeights * boxWidth) ^ 2];
		
}
	public int cellRow(int cellNumber){
		return cellNumber / boxHeights;
	}

	public int cellCol(int cellNumber){
		return cellNumber % boxWidth;
	}

	public int cellVal(int cellNumber){
		return boardCells[cellNumber];
	}
	
	
	public int findBoxNumber (int cellNumber) {
		return ( cellCol(cellNumber)/boxWidth) + (cellRow(cellNumber)/ boxHeights * boxHeights);
		
	}
	


private int getBoxWidth () {
	
	return boxWidth;
	
}

private int getboxHeights () {
	
	return boxHeights;
	
}

private int getboardSize () {
	
	return boardSize;
}
	
public String toString() {
	String string = " ";
	for(int i= 0; boardCells.length > i ;i++){
		//string = string + boardCells[i];
			if((i % (boxWidth * boxHeights)) == (boxWidth * boxHeights) - 1 /*end of line*/){
//				add new line char. come down here once per row
				string = string + boardCells[i] + "\n";
				
			}
			else{
				string = string + boardCells[i];
			}
	}
return string;
}

public void setValue(int value) {
	this.value = value;
}
int getBox (int index) {
	if (index == 0) {
	return 0;
}
return ((cellCol(index)/this.boxWidth) + this.boxHeights +
		(cellRow(index)/this.boxWidth));

}
int [] getBoxValue (int boxNum){
	int [] arr = new int [9];
	int Counter= 0;
	for ( int i = 0; i < 8; i++) {
		if (getBox(i)== boxNum) {
			arr[arrCounter] = i;
			Counter++;
		}
	}
	return arr;
}
}


