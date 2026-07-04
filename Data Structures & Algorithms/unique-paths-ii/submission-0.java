class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] resGrid = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            } else {
                resGrid[i][0] = 1;
            }
        }

        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                break;
            } else {
                resGrid[0][j] = 1;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    resGrid[i][j] = 0;
                } else {
                    resGrid[i][j] = resGrid[i - 1][j] + resGrid[i][j - 1];
                }
            }
        }

        return resGrid[m - 1][n - 1];
    }
}