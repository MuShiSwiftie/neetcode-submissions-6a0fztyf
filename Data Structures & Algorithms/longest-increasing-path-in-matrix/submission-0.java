class Solution {
    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int[][] dp;
    public int longestIncreasingPath(int[][] matrix) {
        int ROWS = matrix.length, COLS = matrix[0].length;
        dp = new int[ROWS][COLS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                dp[i][j] = -1;
            }
        }
        int res = 0;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                res = Math.max(res, dfs(matrix, i, j, Integer.MIN_VALUE));
            }
        }
        return res;
    }

    private int dfs(int[][] matrix, int r, int c, int prevVal) {
        int ROWS = matrix.length, COLS = matrix[0].length;
        if (r < 0 || r >= ROWS || c < 0 || c >= COLS || matrix[r][c] <= prevVal) {
            return 0;
        }
        if (dp[r][c] != -1) {
            return dp[r][c];
        }
        int res = 1;
        for (int[] dir : dirs) {
            res = Math.max(res, 1 + dfs(matrix, r + dir[0], c + dir[1], matrix[r][c]));
        }
        return dp[r][c] = res;
    }
}
