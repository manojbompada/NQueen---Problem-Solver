# NQueen---Problem-Solver
NQueen problem solver using random restart hill climbing algortihm:

Solving N queen problem using random restart.

Compiler: Java
Input: ‘N’ – no. of queens to be solved
Output: A solved state in which ‘X’ represents the presence of a queen in the chess board.
N-queen problem formulation:
State: A state of N queen board consists of N queens on the board one per column
Initial State: Any random state with one queen per column on the chess board
Successor function: Movement of queen in each column from one to another square. By this each state has 56 successors.
Goal test: Check whether there is any conflict between any two queens on the board.

Program Structure:
The program has four classes NqueenSolver, RandomHill, BoardState, QueenState.
NqueenSolver is the main class in which it takes the input for number of queens to be solved, calls other classes to solve the board and prints the board.
RandomHill class executes the random restart hill climbing algorithm.
BoardState class maintains the chess board by generating the successors of the current board and their corresponding heuristics.
QueenState class maintains the position of queen in the chess board.

Procedure to compute the heuristic function:
The heuristic cost function h is the number of pairs of queens that are attacking each other, either directly or indirectly. This value will be zero for the global minimum
