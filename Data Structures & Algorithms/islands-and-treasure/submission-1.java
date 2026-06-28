class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    q.offer(new int[] {i, j});
                }
            }
        }

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int steps = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cor = q.poll();
                int row = cor[0], col = cor[1];
                for (int[] dir : dirs) {
                    int nr = row + dir[0], nc = col + dir[1];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n || grid[nr][nc] != Integer.MAX_VALUE) {
                        continue;
                    }
                    q.add(new int[] {nr, nc});
                    grid[nr][nc] = steps + 1;
                }
            }
            steps++;
        }
    }
}
