import java.util.*;

/*
 * In this class Random hill algorithm will be executed
 */
public class RandomHill {
	
	private int qCount;// Queens size
	private int randomcount=0; // keeps track of number of random restarts
	private BoardState initBoard;
	private QueenState[] initQpos;
	private static int stepsclimbed; // keeps track of number of steps climbed or state changes
	
 
/*
 * Constructor class for initial chess board
 */

	public RandomHill(QueenState[] Q, int queens)
	{
		qCount = queens;
		initBoard = new BoardState(qCount);
		
		initQpos = new QueenState[qCount];
		for(int i=0; i<Q.length; i++){
			int row = Q[i].getqueenRow();
			int col = Q[i].getqueenCol();
			initQpos[i] = new QueenState(row,col);
		}
		initBoard.setqueenPosition(initQpos);
		initBoard.heuristicEvaluation();
	}

/*
 * This method restarts the hill-climbing
 */
	public void randomRestart()
	{
		initBoard = new BoardState(qCount); 
		initQpos = new QueenState[qCount];
		randominitBoard();
	}

/*
 * This method executes the random restart hill climbing algorithm
 */
	public BoardState randomHill()
	{

		BoardState presentBoard = getinitBoard();
		setinitBoard(presentBoard);
		int heuristic = presentBoard.getheuristicValue();

		while(heuristic!=0){
            		
			BoardState successorBoard = hillClimbing();
			heuristic = successorBoard.getheuristicValue();

			if(heuristic!=0){
				// Restarts the hill climbing if the heuristics of final board is not zero
				randomRestart();
				randomcount++;
				
			}else
				presentBoard = successorBoard;
		}
		return presentBoard;
	}

/*
 * This method executes the hill climbing algorithm
 */
	public BoardState hillClimbing()
	{
		BoardState present = initBoard;

		while(true){
			ArrayList<BoardState> successors = present.successorBoard(present);

			BoardState successorBoard = null;

			for(int i=0; i<successors.size(); i++){
				if(successors.get(i).compareTo(present) < 0){
					// changes the state if the heuritics of successor less than parent
					successorBoard = successors.get(i);
					stepsclimbed++; 

				}
			}

			if(successorBoard==null)
				return present;

			present = successorBoard;
		}
	}

/*
 * This method initializes the chess board to a random initial state
 */
	public void randominitBoard(){
		//sets up a pseudo random start state
		Random rand = new Random();
		for(int col=0; col<qCount; col++){
			initQpos[col] = new QueenState(rand.nextInt(qCount), col);
		}
		initBoard.setqueenPosition(initQpos);
		initBoard.heuristicEvaluation();
		//	System.out.println("start:\n"+start);
	}

	public void setinitBoard(BoardState board){
		initBoard = board;
	}


	public BoardState getinitBoard(){
		return initBoard;
	}


	public void setRandomcount(int randomcount) {
		this.randomcount = randomcount;
	}

	public int getRandomcount() {

		return randomcount;
	}

	public static int getStepsclimbed() {
		return stepsclimbed;
	}

	public void setStepsclimbed(int stepsclimbed) {
		RandomHill.stepsclimbed = stepsclimbed;
	}

}
