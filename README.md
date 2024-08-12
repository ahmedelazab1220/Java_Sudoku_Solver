# Sudoku Solver

A Java-based Sudoku solver with a graphical user interface (GUI) built using Swing. This project demonstrates a practical implementation of the backtracking algorithm to solve Sudoku puzzles, complete with a user-friendly interface that allows users to input puzzles, view solutions, and manage board state interactively.

## Key Features

- Interactive GUI: Provides a visual Sudoku board where users can click tiles to select and enter numbers.
- Backtracking Solver: Utilizes a backtracking algorithm to solve Sudoku puzzles efficiently.
- Error Handling: Validates user inputs and displays error messages for invalid entries.
- Threaded Solver: Uses a separate thread to solve the puzzle, ensuring the GUI remains responsive.

## Purpose

This project is designed to provide both a functional Sudoku solver and an intuitive interface for users to interact with. It is suitable for educational purposes to understand Sudoku solving techniques and GUI development in Java.

## Usage

- Launch the Application: Run the Main class as described above.
- Input Sudoku Puzzle: Click on tiles to select them and type numbers (1-9) using your keyboard.
- Solve the Puzzle: Click the "Solve" button to solve the Sudoku puzzle.
- Reset the Board: Click the "Reset" button to clear all tiles.

## GUI Components

- Tile: Represents each cell in the Sudoku grid. Click to highlight and enter numbers.
- Control Panel: Contains "Solve" and "Reset" buttons.

## Project Structure

```

sudoku_solver
|
├── src
|   ├── sudoku
|   |   ├── Location.java
|   |   ├── SolverThread.java
|   |   ├── SortByEmptyTiles.java
|   |   ├── Subgrid.java
|   |   ├── SudokuSolver.java
|   |   ├── SudokuSolverListener.java
|   ├── view
│   |   ├── GUI.java
|   |   ├── Tile.java
│   |
|   └── Main.java
├── out
│   └── production
│       └── sudoku_solver
│           └── (compiled classes)
├── .gitignore
├── README.md
└── sudoku_solver.iml

```

## Installation

- **`Clone the repository`**:

  - git clone https://github.com/ahmedelazab1220/Java_Sudoku_Solver.git
  - you can also download Zip file and extract.

- **`Running the Project`**

  - `Compile the project:`
    - javac Main.java
  - `Run the Main class to start the application:`
    - java Main.java

- **`Note`**
  - you must go to path in your pc to run this commands correctly.

## Sudoku Solver GUI Preview

- ![UnSolvedSudoku](https://github.com/user-attachments/assets/f67dd53c-cd61-484d-bda3-22dad68e9121)

- ![SolvedSudoku](https://github.com/user-attachments/assets/2375367b-2a8e-453b-9612-0ebd4ef928cc)

## License

This project is licensed under the Apache License 2.0 - see the <a href = "https://github.com/ahmedelazab1220/Java_Sudoku_Solver/blob/main/LICENSE"> LICENSE </a> file for details.

## Conclusion

This project showcases a Sudoku solver implemented in Java, featuring both backend logic and a graphical user interface (GUI). The code is well-organized, with separate packages for core Sudoku functionalities and the GUI components. Users can easily run the project from the terminal and view a preview of the GUI included in the README.md under the title "Sudoku Solver GUI Preview." This structure ensures maintainability and clarity, making it straightforward to understand, extend, and use the Sudoku solver application.
