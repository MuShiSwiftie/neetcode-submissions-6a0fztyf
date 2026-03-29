class Solution {
    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    record Pair<A, B> (A first, B second) {}
    public int numIslands(char[][] grid) {
        int rows = grid.length, cols = grid[0].length;

        int res = 0;
        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && !visited.contains(new Pair<>(i, j))) {
                    res++;
                    bfs(grid, i, j, visited);
                }
            }
        }
        return res;
    }

    private void bfs(char[][] grid, int i, int j, Set<Pair<Integer, Integer>> visited) {
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        visited.add(new Pair<>(i, j));
        q.add(new Pair<>(i, j));

        while(!q.isEmpty()) {
            Pair<Integer, Integer> pair = q.poll();
            int row = pair.first(), col = pair.second();

            for (int[] dir : DIRECTIONS) {
                int nr = row + dir[0], nc = col + dir[1];
                if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && !visited.contains(new Pair<>(nr, nc)) && grid[nr][nc] == '1') {
                    q.add(new Pair<>(nr, nc));
                    visited.add(new Pair<>(nr, nc));
                }
            }
        } 
    }
}
