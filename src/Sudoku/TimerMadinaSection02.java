package Sudoku;

public class TimerMadinaSection02 {

	long startTime;
	long currentTime;
	
	public void start () {
		
		startTime = System.currentTimeMillis();
	}
	
	public long stop(){
		//return result
		currentTime = System.currentTimeMillis();
		return currentTime;
	}
	
	public long getDuration() {
		//Subtract current time - start time
		return currentTime - startTime; 	
	}
	
	public long currentTime () {
		
	return currentTime - startTime; 
	}
}