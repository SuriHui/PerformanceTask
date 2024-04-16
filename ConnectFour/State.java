public class State
{
    private int gameState = Constants.STANDBY;
    private int whoseMove = Constants.X;
    private String xName = "";
    private String oName = "";
    private int[][] board = new int[Constants.BOARD_LENGTH][Constants.BOARD_HEIGHT];

    public boolean isWinner() {
        int total;
        for (int row=0; row<Constants.BOARD_HEIGHT; row++) {
            total = getBoardCell(row, 0) + getBoardCell(row,1) + getBoardCell(row,2) + getBoardCell(row,3) + getBoardCell(row,4) + getBoardCell(row,5);
            if (total == -4 || total == 4) return true;
        }
        for (int col=0; col<Constants.BOARD_LENGTH; col++) {
            total = getBoardCell(0, col) + getBoardCell(1,col) + getBoardCell(2, col) + getBoardCell(3, col) + getBoardCell(4, col) + getBoardCell(5, col) + getBoardCell(6, col);
            if (total == -4 || total == 4) return true;
        }
        total = getBoardCell(0, 0) + getBoardCell(1,1) + getBoardCell(2, 2) + getBoardCell(3, 3) + getBoardCell(4, 4) + getBoardCell(5, 5);
        if (total == -4 || total == 4) return true;
        total = getBoardCell(6, 0) + getBoardCell(4, 2) + getBoardCell(3,3) + getBoardCell(2,4) + getBoardCell(1, 5) + getBoardCell(0, 6);
        if (total == -4 || total == 4) return true;
        return false;
    }

    public boolean isTie() {
        for (int row=0; row<Constants.BOARD_HEIGHT; row++) {
            for (int col=0; col<Constants.BOARD_LENGTH; col++) {
                if (getBoardCell(row,col) == Constants.BLANK) {
                    return false;
                }
            }
        }
        return true;
    }

    public int getGameState() {
        return gameState;
    }

    public void setGameState(int gameState) {
        this.gameState = gameState;
    }

    public int getWhoseMove() {
        return whoseMove;
    }

    public void setWhoseMove(int whoseMove) {
        this.whoseMove = whoseMove;
    }

    public String getXName() {
        return xName;
    }

    public void setXName(String xName) {
        this.xName = xName;
    }

    public String getOName() {
        return oName;
    }

    public void setOName(String oName) {
        this.oName = oName;
    }
    
    public int getBoardCell (int row, int col) {
        return this.board[row][col];
    }

    public void setBoardCell(int row, int col, int value) {
        this.board[row][col] = value;
    }
    
    // https://gist.github.com/jonathan-irvin/97537512eb65a8bbcb9a
    public static boolean validate(int col, int board, int row) {
        // check valid column
        if (col < 0 || col > Constants.BOARD_HEIGHT) {
            return false;
        }
        //check full column
        if (board != 0) {
            return false;
        }
        return true;
    }
}