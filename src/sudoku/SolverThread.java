package sudoku;

public class SolverThread extends Thread{
    private int[][] board;
    private SudokuSolverListener sudokuSolverListener;

    public SolverThread(int[][] board, SudokuSolverListener sudokuSolverListener) {
        this.board = board;
        this.sudokuSolverListener = sudokuSolverListener;
    }

    @Override
    public void run() {
        SudokuSolver sudokuSolver = new SudokuSolver(board,sudokuSolverListener);
        sudokuSolver.startSolve();
    }
}
