import java.util.*;
/*
 * NqueenSolver is the main class in which it takes the input for number of queens to be solved,
 * calls other classes to solve the board and prints the board.
 */
public class NQueensSolver {

	private static int Queensize; // number of queens to be solved

	public static void main(String[] args){

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number of queens to be solved :");
		Queensize = scan.nextInt();		

		NQueensSolver board = new NQueensSolver();
		int Restartcount = 0;// counter for number of resarts
		int Stepsclimbed = 0;// counter for number of stepsclimbed


		QueenState[] startBoard = board.randomBoardState();

		RandomHill randomRestart = new RandomHill(startBoard,Queensize);
		BoardState randomSolved = randomRestart.randomHill();

		if(randomSolved.getheuristicValue()==0){
			System.out.println("Solved board: ");
			
			System.out.println("Here 'X' indicates presence of a queen in the chess board ");
			System.out.println(randomSolved);
			
		}

		Restartcount = randomRestart.getRandomcount();
		Stepsclimbed = RandomHill.getStepsclimbed();
		System.out.println("Total no. of random Restarts : " +Restartcount);
		System.out.println("Total steps of climbing: " +Stepsclimbed);
	}
	
	/**
	 *This method initializes the chess board to a random initial state
	 */
	public QueenState[] randomBoardState(){
		QueenState[] queenStartpos = new QueenState[Queensize];
		Random rand = new Random();

		for(int col=0; col<Queensize; col++){
			queenStartpos[col] = new QueenState(rand.nextInt(Queensize),col);
		}
		return queenStartpos;
	}
}

