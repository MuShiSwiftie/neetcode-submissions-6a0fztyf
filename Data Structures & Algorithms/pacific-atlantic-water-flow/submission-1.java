class Solution {
    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROW = heights.length, COL = heights[0].length;
        boolean[][] pac = new boolean[ROW][COL];
        boolean[][] atl = new boolean[ROW][COL];
        for (int r = 0; r < ROW; r++) {
            dfs(r, 0, pac, heights);
            dfs(r, COL - 1, atl, heights);
        }
        for (int c = 0; c < COL; c++) {
            dfs(0, c, pac, heights);
            dfs(ROW - 1, c, atl, heights);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                if (pac[r][c] && atl[r][c]) {
                    res.add(Arrays.asList(r, c));
                }
            }
        }
        return res;
    }

    private void dfs(int r, int c, boolean[][] ocean, int[][] heights) {
        ocean[r][c] = true;
        for (int[] dir : directions) {
            int row = r + dir[0], col = c + dir[1];
            if (row < heights.length && row >= 0 
            && col < heights[0].length && col >= 0 
            && !ocean[row][col] && heights[r][c] <= heights[row][col]) {
                dfs(row, col, ocean, heights);
            }
        }
    }
}
