package Sudoku;
import java.io.File;


	public class  mainMadinaSection02{ 

	public static void main (String[] args ) throws Exception{
		
		   if ( args.length < 1) {
		  
		
		  System.out.print ("Error: Missing File"); 
		  System.exit(1);
		   }
		   else {
		 File file = new File (args[0]);
		  SudokuToSatReducerMadinaSection02 sud = new SudokuToSatReducerMadinaSection02 (file);
		  sud.createBoard(file);
		  sud.reduceBoard();
		   }
		  
}
}
