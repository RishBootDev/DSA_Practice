class Solution {
   
   public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean vis[][] = new boolean[board.length][board[0].length];
                boolean ans = helper(board, i, j, word, 0, vis);
                if(ans) return true;
            }
        }
        return false;
    }
    
    public boolean helper(char [][] board, int r, int c, String word, int i, boolean [][]vis) {
        if(i == word.length()) return true;
        if(!check(board, r, c)) return false;
        if (vis[r][c]) return false;
        if(board[r][c] != word.charAt(i)) return false;
        
        vis[r][c] = true;
        boolean up = helper(board, r - 1, c, word, i + 1, vis);
        boolean down = helper(board, r + 1, c, word, i + 1, vis);
        boolean left = helper(board, r, c - 1, word, i + 1, vis);
        boolean right = helper(board, r, c + 1, word, i + 1, vis);
        vis[r][c] = false;
        
        return up || down || left || right;
    }
    public boolean check(char [][] board, int r, int c) {
        if(r >= board.length || c >= board[0].length) return false;
        if(r < 0 || c < 0) return false;
        return true;
    }
}