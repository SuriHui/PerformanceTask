import java.util.Scanner;
import java.util.InputMismatchException;
/**
 * UI class
 */
public class UI
{
    Scanner scanner;
    public UI() {
        scanner = new Scanner(System.in);         
    }

    // Utility methods
    public String getXOrO(int whoseMove) {
        if (whoseMove == -1) {
            return "X";
        } else if (whoseMove == 1) {
            return "O";
        } else {
            return " ";
        }

    }

    public String getPlayerName(int whoseMove, String xName, String yName) {
        return (whoseMove == -1) ? xName : yName;
    }

    public boolean isLegalMove(State state, int row, int col) {
        if (1 <= col && col <= Constants.BOARD_LENGTH &&
            state.getBoardCell(row-1, col- 1) == Constants.BLANK) {
            return true;
        } else {
            System.out.println(Constants.INVALID_MOVE_ERROR);
            return false;
        } 
    }
        // Prompt for input methods
        public String promptForName(String player) {
        System.out.printf(Constants.GET_PLAYER_NAME, player);
        return scanner.next();
    }

    public int getMoveCol(int whoseMove, String xName, String oName) {
        int col = 0;
        while (true) {
            System.out.printf(Constants.GET_COL_MOVE, getXOrO(whoseMove), getPlayerName(whoseMove, xName, oName));
            try {
                col = scanner.nextInt();
                if (col < 1 || col > Constants.BOARD_LENGTH) {
                    printInvalidColumn();
                    System.out.println();
                    scanner.nextLine();
                }
                else {
                    return col;
                }
            } catch (InputMismatchException error) {
                printInvalidColumn();
                System.out.println();
                scanner.next();
            }
        }
    }

    public boolean startNewGame() {
        System.out.println(Constants.START_NEW_GAME);
        String yesOrNo = scanner.next();
        return yesOrNo.equals("Y") || yesOrNo.equals("y");
    }

    // Printing text methods
    public void printWelcome() {
        System.out.println(Constants.TITLE);
    }

    public void printBoard(State state) {
        System.out.println(Constants.DIVIDER_STRING);
        for (int row = 0; row < Constants.BOARD_HEIGHT; row++) {
            System.out.printf(Constants.BOARD_STRING, getXOrO(state.getBoardCell(row, 0)), getXOrO(state.getBoardCell(row, 1)), getXOrO(state.getBoardCell(row, 2)), getXOrO(state.getBoardCell(row, 3)), getXOrO(state.getBoardCell(row, 4)), getXOrO(state.getBoardCell(row, 5)), getXOrO(state.getBoardCell(row,6)));
            System.out.println();
            System.out.println(Constants.DIVIDER_STRING);
        }
    }

    public void printInvalidColumn() {
        System.out.printf(Constants.INVALID_COLUMN);
    }

    public void printInvalidMove(int col) {
        System.out.printf(Constants.INVALID_MOVE_ERROR, col);
    }

    public void printMove(State state, int col) {
        System.out.printf(Constants.PRINT_MOVE, getXOrO(state.getWhoseMove()),getPlayerName(state.getWhoseMove(), state.getXName(), state.getOName()), col);
        System.out.println(); 
    } 

    public void printWinner(State state) {
        printBoard(state);
        System.out.printf(Constants.WINNER, getXOrO(state.getWhoseMove()),getPlayerName(state.getWhoseMove(), state.getXName(), state.getOName()));
        System.out.println();
    }

    public void printTieGame(State state) {
        printBoard(state);
        System.out.println(Constants.TIE_GAME);
    }
}
