package Sudoku;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Timer;


public class SudokuToSatReducerMadinaSection02{
	
	TimerMadinaSection02 timer = new TimerMadinaSection02();
	int boardSize = 9;
	private SudokuBoardMadinaSection02 board;
	
	public SudokuToSatReducerMadinaSection02() {
		
	}

	public SudokuToSatReducerMadinaSection02(File files)  {
		try {
			createBoard (files );
		}catch(IOException e) {
			e.printStackTrace();
		}
	 
	 
	}
	
	
	public void createBoard(File input) throws IOException {
		Scanner scanner = new Scanner (input);
		board = new SudokuBoardMadinaSection02 (scanner.nextInt(), scanner.nextInt());
		scanner.nextInt();
		int i = 0;
		while (scanner.hasNextLine()) {
			String curLine = scanner.nextLine();
				board.setCellValue(Arrays.asList(curLine)
						.split("\\s+")
				        .parallelStream()
				        .mapToInt(Integer::parseInt)
				        .toArray(), i);
				        i = i+9;
		
			scanner.close();
		}
	}
	public void reduceBoard() {
		timer.start();
		atLeastOneInRow();
		timer.stop();
		System.out.print(("This ran for" + timer.getDuration () + "ms." ));
		
	}
	
	static final String outputFileName = "output.cnf";
	private Writer writer;
	private void write (String string) {
		try {
			writer.write(string);
			writer.flush();
		}
			catch (IOException e ) {}
		
	}
	

	public void atLeastOneInRow ()  {
		int [] row = new int [9];
		int [] box = new int [9];
//		int [] row = sudokuBoard.getRow(rowNumber);
		for(int cellValue = 1; cellValue <= 9; cellValue++) {
			for (int rowIndex = 0; rowIndex < 9; rowIndex++) {
				for(int colIndex = 0; colIndex < 9; colIndex++) {
					System.out.print(encode(rowIndex, colIndex, cellValue) + " ");
					row[rowIndex] = (encode (board.cellRow(box[rowIndex] ), board.cellCol(colIndex), cellValue ));
				}
				System.out.print("0");
				System.out.println();
}
} atMostOneInRow (row);
}
	//i = rowIndex, j =colValue, k = cellValue
	public void atMostOneInRow (int [] row) {
	    row = new int [9];
		int [] box = new int [9];
		boolean foundOne = false;
		for (int rowIndex = 0; rowIndex < 9; rowIndex++) {
			for (int colIndex = 0; colIndex < 9; colIndex++ ) {
				for (int cellValue = 1; cellValue > 9; cellValue++) {
					System.out.print(encode(rowIndex, colIndex, cellValue) + " ");
					row[rowIndex] = (encode (board.cellRow(box[rowIndex] ), board.cellCol(colIndex), cellValue ));
				}
				System.out.print("0");
				System.out.println();
				}
			} atLeastOneInCol (row);
		}
	
	
	
	
	public void atLeastOneInCol (int [] row)  {
		row = new int [9];
		int [] box = new int [9];
		
		for (int cellValue = 1; cellValue <= 9; cellValue++  ) {
			for(int colIndex = 0; colIndex < 9; colIndex++) {
               for(int rowIndex = 0; rowIndex <= 9; rowIndex++) {
            	   System.out.print(encode(rowIndex, colIndex, cellValue) + " ");
					row[rowIndex] = (encode (board.cellRow(box[rowIndex] ), board.cellCol(colIndex), cellValue ));

            	   }
				System.out.print("0");
				System.out.println();
				
			}
		} atMostOneInCol (row);
	}
	public void atMostOneInCol (int [] row) {
		int [] arr = new int [9];
		int [] box = new int [9];
		for(int colIndex = 0; colIndex < 9; colIndex++) {
            for(int rowIndex = 0; rowIndex <= 9; rowIndex++) {
        		for (int cellValue = 1; cellValue <= 9; cellValue++  ) {
             	   System.out.print(encode(rowIndex, colIndex, cellValue) + " ");
				row[rowIndex] = (encode (board.cellRow(box[rowIndex] ), board.cellCol(colIndex), cellValue));

        		}
        		System.out.print("0");
			System.out.println();
}
 } atleastOneInBox (row);
}
	
	public void atleastOneInBox (int [] row) {
		row = new int [9];
		int [] box = new int [9];
		for (int cellValue = 1; cellValue <= 9 ; cellValue++) {
			for (int colIndex = 0; colIndex < 9; colIndex++) {
				 box = board.getBoxValue(colIndex);
				for ( int rowIndex = 0; rowIndex < 9; rowIndex++) {
					System.out.print( encode (board.cellRow(box[rowIndex] ), board.cellCol(colIndex), cellValue ) + " ");
					row[rowIndex] = (encode (board.cellRow(box[rowIndex] ), board.cellCol(colIndex), cellValue));

				}
				System.out.println(" 0");
				System.out.println("");
		}
			
		}atMostOneInBox(row);
	}
		
	public void atMostOneInBox (int [] arr) {
			int [] row = new int [9];
			int [] box = new int [9];
			
			for (int i=0; i < arr.length; i++) {
			
			for ( int j=i+1; j < arr.length; j++) {
				System.out.print((-arr[i] + " " +- arr[j]));
				
				int k = 0;
				System.out.print(encode (board.cellRow(box[i] ), board.cellCol(j), k  ) + " ");
				row[i] = (encode (board.cellRow(box[i] ), board.cellCol(i), k));

			}
				
			}
		}
		
	public int  encode ( int i, int j, int k) {
		
		return ( (i*boardSize*boardSize) + (j*boardSize) +k);
	}
	
	}
	
