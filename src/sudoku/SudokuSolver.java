package sudoku;

import java.util.ArrayList;
import java.util.Arrays;

public class SudokuSolver {

    private int[][] board;
    private final SudokuSolverListener sudokuSolverListener;
    private Subgrid[] subgrids;
    private ArrayList<Location> emptyTiles;


    public SudokuSolver(int[][] board, SudokuSolverListener sudokuSolverListener) {
        this.sudokuSolverListener = sudokuSolverListener;
        this.board = board;
        init();
    }

    private int getSubgridIndex(Location location) {
        return ((location.row/3)*3+(location.column/3));
    }

    private Location[] getSubgridTiles(int subgridIndex) {
        Location[] tiles = new Location[9];
        int index = 0;
        for(int row = (subgridIndex/3)*3; row < (subgridIndex/3)*3 + 3; row++) {
            for(int column = (subgridIndex%3)*3; column < (subgridIndex%3)*3 + 3; column++) {
                tiles[index] = new Location(row,column);
                index++;
            }
        }
        return tiles;
    }

    private Location[] getSubgridTiles(Location location) {
        return getSubgridTiles(getSubgridIndex(location));
    }

    private Location[] getColumnTiles(Location location) {
        Location[] tiles = new Location[9];
        for(int row = 0; row < 9; row++) {
            tiles[row] = new Location(row,location.column);
        }
        return tiles;
    }

    private Location[] getRowTiles(Location location) {
        Location[] tiles = new Location[9];
        for(int column = 0; column < 9; column++) {
            tiles[column] = new Location(location.row,column);
        }
        return tiles;
    }

    private ArrayList<Integer> takenSubgridNumbers(Location location) {
        ArrayList<Integer> takenNumbers = new ArrayList<>();
        Location[] tiles = getSubgridTiles(location);
        for(Location l : tiles) {
            int number = board[l.row][l.column];
            if(number != 0) {
                takenNumbers.add(number);
            }
        }
        return takenNumbers;
    }

    private ArrayList<Integer> takenColumnNumbers(Location location) {
        ArrayList<Integer> takenNumbers = new ArrayList<>();
        Location[] tiles = getColumnTiles(location);
        for(Location l : tiles) {
            int number = board[l.row][l.column];
            if(number != 0) {
                takenNumbers.add(number);
            }
        }
        return takenNumbers;
    }

    private ArrayList<Integer> takenRowNumbers(Location location) {
        ArrayList<Integer> takenNumbers = new ArrayList<>();
        Location[] tiles = getRowTiles(location);
        for(Location l : tiles) {
            int number = board[l.row][l.column];
            if(number != 0) {
                takenNumbers.add(number);
            }
        }
        return takenNumbers;
    }

    private ArrayList<Integer> getPossibleMoves(Location location) {
        ArrayList<Integer> possibleMoves = new ArrayList<>();
        if(board[location.row][location.column] == 0) {
            ArrayList<Integer> takenRowNumbers = takenRowNumbers(location);
            ArrayList<Integer> takenColumnNumbers = takenColumnNumbers(location);
            ArrayList<Integer> takenSubgridNumbers = takenSubgridNumbers(location);


            for(Integer number = 1; number < 10; number++) {
                if(!takenRowNumbers.contains(number) && !takenColumnNumbers.contains(number) && !takenSubgridNumbers.contains(number)) {
                    possibleMoves.add(number);
                }
            }
        }
        return possibleMoves;
    }


    private void initializeSubgrids() {
        subgrids = new Subgrid[9];
        for(int subgridIndex = 0; subgridIndex < 9; subgridIndex++) {
            Location[] tiles = getSubgridTiles(subgridIndex);
            ArrayList<Location> emptyTiles = new ArrayList<>();
            for(Location tile : tiles) {
                if(board[tile.row][tile.column] == 0) {
                    emptyTiles.add(new Location(tile.row,tile.column));
                }
            }
            Subgrid subgrid = new Subgrid(subgridIndex,emptyTiles);
            subgrids[subgridIndex] = subgrid;
        }
        Arrays.sort(subgrids, new SortByEmptyTiles());
        System.out.println("SORTED SUBGRID'S:");
        for(Subgrid s : subgrids) {
            System.out.print(s.subgridIndex + " ");
        }
        System.out.println(" ");
    }

    private void changeTileNumber(Location location, Integer number) {
        board[location.row][location.column] = number;
        sudokuSolverListener.tileChanged(location, number);
        //populateBoardPossibleMoves();
    }

    private void init() {
        //populateBoardPossibleMoves();
        initializeSubgrids();
    }

    public void startSolve() {
        emptyTiles = new ArrayList<>();
        for(Subgrid subgrid : subgrids) {
            emptyTiles.addAll(subgrid.emptyTiles);
        }
        dfs(0);
    }

    private boolean dfs(int tileIndex) {
        if(tileIndex == emptyTiles.size()) {
            return true;
        }
        Location emptyTileLocation = emptyTiles.get(tileIndex);
        ArrayList<Integer> possibleMoves = getPossibleMoves(emptyTileLocation);
        for(Integer possibleMove : possibleMoves) {
            changeTileNumber(emptyTileLocation,possibleMove);
            if(dfs(tileIndex+1)) {
                return true;
            }
        }
        changeTileNumber(emptyTileLocation,0);
        return false;
    }


}