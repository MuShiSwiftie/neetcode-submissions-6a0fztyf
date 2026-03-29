class Solution {
    private int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public void solve(char[][] board) {
        int row = board.length, col = board[0].length;
        for (int r = 0; r < row; r++) {
            if (board[r][0] == 'O') {
                dfs(board, r, 0);
            }
            if (board[r][col - 1] == 'O') {
                dfs(board, r, col - 1);
            }
        }
        for (int c = 0; c < col; c++) {
            if (board[0][c] == 'O') {
                dfs(board, 0, c);
            }
            if (board[row - 1][c] == 'O') {
                dfs(board, row - 1, c);
            }
        }
        
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                } else if (board[r][c] == 'T') {
                    board[r][c] = 'O';
                } 
            }
        }
    }

    private void dfs(char[][] board, int r, int c) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != 'O') {
            return;
        }
        board[r][c] = 'T';
        for (int[] dir : directions) {
            dfs(board, r + dir[0], c + dir[1]);
        }
    }
}
