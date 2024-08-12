package sudoku;


public interface SudokuSolverListener {
    void tileChanged(Location tileLocation, int newValue);
}
