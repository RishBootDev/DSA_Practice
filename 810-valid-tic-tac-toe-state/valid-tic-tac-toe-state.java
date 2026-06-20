class Solution {

    public boolean validTicTacToe(String[] board) {

        int x = 0;
        int o = 0;

        for (String row : board) {
            for (char c : row.toCharArray()) {
                if (c == 'X') x++;
                else if (c == 'O') o++;
            }
        }
        if (o > x || x - o > 1) {
            return false;
        }

        boolean xWin = isWinner(board, 'X');
        boolean oWin = isWinner(board, 'O');

        if (xWin && oWin) {
            return false;
        }
        if (xWin && x != o + 1) {
            return false;
        }
        if (oWin && x != o) {
            return false;
        }

        return true;
    }

    private boolean isWinner(String[] board, char ch) {

        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == ch &&
                board[i].charAt(1) == ch &&
                board[i].charAt(2) == ch) {
                return true;
            }
        }

        for (int j = 0; j < 3; j++) {
            if (board[0].charAt(j) == ch &&
                board[1].charAt(j) == ch &&
                board[2].charAt(j) == ch) {
                return true;
            }
        }

        if (board[0].charAt(0) == ch &&
            board[1].charAt(1) == ch &&
            board[2].charAt(2) == ch) {
            return true;
        }

        if (board[0].charAt(2) == ch &&
            board[1].charAt(1) == ch &&
            board[2].charAt(0) == ch) {
            return true;
        }

        return false;
    }
}