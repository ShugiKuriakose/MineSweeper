package MineSweeper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MineSweeper {
	
	// Method to generate random mines
	public static ArrayList<Integer> generateMines(int mineSize, int gridSize) {
		int[] mines = new int[mineSize];
		Random random = new Random();
	    ArrayList<Integer> mineList = new ArrayList<Integer>();

	    while (mineList.size() < mineSize) { // how many numbers u need 
	        int a = random.nextInt(gridSize*gridSize - 2)+1; // this will give numbers between 1 and gridSize*gridSize - 1.

	        if (!mineList.contains(a)) {
	            mineList.add(a);
	        }
	    }
	    System.out.println("");
		
		return mineList;
	}
	
	// Method to display the game grid
	public static Boolean displayGameGrid(ArrayList<Integer> mines, int[] sweptArray, Boolean gameNotOver, int size) {
		int[][] gameGrid = new int[size][size];
		System.out.println(" ");
		System.out.println("     ----- MINESWEEPER -----    ");
		for (int i=0; i<gameGrid.length; i++) {
			System.out.print(" ");
			System.out.printf(" %d", i);}
		for (int i=0; i<gameGrid.length; i++) {
			System.out.println(" ");
			System.out.print(i);
			for (int j=0; j<gameGrid.length; j++) {
				int cell = gameGrid.length*i+j;
				if(sweptArray[cell] != -1 && sweptArray[cell] != -2)  {
				if(mines.contains(cell)) {
					System.out.println("");
					System.out.println("  *********    Boom   ******** ");
					System.out.println("  *********  Game Over  ****** ");
					System.out.println("  *********  Try Again  ****** ");
				return (!gameNotOver);}
				else System.out.printf(" %d ",sweptArray[cell]);
				} else System.out.print(" - ");
				
			}	}
		List<Integer> sweptArrayList = Arrays.stream(sweptArray).boxed().collect(Collectors.toList());
		if(!sweptArrayList.contains(-1))  gameNotOver = false;
	   return gameNotOver;	
	}
	
	
	// method to check the number of mines around the selected cell and update the game grid array
	public static int[] cellToCheck(int i, int j, int[] sweptArray, ArrayList<Integer> mines, int size) {
				
				Boolean notFoundMine = true;
				while(notFoundMine) {
				int mine = 0;
				for (int k= i-1; k< i+2; k++) {
					for (int l= j-1; l< j+2; l++) {
						if(mines.contains(size*k+l)) {
							mine = mine + 1;
							
						}
					}}
				sweptArray[(size*(i)+j)] = mine;
				if(mine > 0) notFoundMine = false;
				else if (i<size-1) {i=i+1; 
				}
				else if (j<size-1) {j=j+1; 
				}
					
				else
					return sweptArray ;	
				}
				
				
		   return sweptArray ;
				
			}
	
	
	
	class Main {
		public static void main(String[] args) {
			
		// Get the Grid Size and Number of Mines	
		Scanner sc = new Scanner(System.in);
		System.out.println(" ");
		System.out.println("Enter Grid Size");
		int size = sc.nextInt();
		System.out.println("Enter the Number of Mines");
		int mineSize = sc.nextInt();
		
		// Generate mines
		ArrayList<Integer> mines = generateMines(mineSize, size);
		
		// Generate the gameGrid
		int[] gameGrid = new int[size*size];
		  Arrays.fill(gameGrid, -1);
		  for(int i=0; i<size*size; i++) {
			  for(int j=0; j<size*size; j++) {
			  if(mines.contains(size*i+j)) gameGrid[size*i+j]=-2;
		  }}
		  
		// Display the grid
		Boolean gameNotOver = true;
		System.out.println(" ");
		System.out.println("Numbers on the top and left shows the grid coordinates ");
		System.out.println("- Cells to uncover ");
		System.out.println("Number on the grid shows the number of surrounding mines ");
		displayGameGrid(mines, gameGrid, gameNotOver, size);
		
		
		while(gameNotOver) {
		
		// Get user input for coordinates of cell to check
		System.out.println(" ");
		System.out.println("Enter the X coordinate");
		int xcell = (sc.nextInt());
		System.out.println("Enter the Y coordinate");
		int  ycell = (sc.nextInt());
		
		
		//Check for mines in or near the user input and add the appropriate number to the gameGrid and display the updated grid
		int[] sweptArray1 = cellToCheck(xcell, ycell, gameGrid, mines, size);
  		gameGrid = sweptArray1;
  		gameNotOver = displayGameGrid(mines, gameGrid, gameNotOver, size);
  		
  		
		//Check if all the cells have been uncovered
  		List<Integer> sweptArrayList = Arrays.stream(gameGrid).boxed().collect(Collectors.toList());
		   Boolean hasWon = false;
			if(!sweptArrayList.contains(-1))  hasWon = true;
			if(hasWon) {
				System.out.println(" ");
				System.out.println("********Game Over*******");
				System.out.println("*********You Won********");}
		  
	  }  }
		  
		}
		
	}
	
	

	
