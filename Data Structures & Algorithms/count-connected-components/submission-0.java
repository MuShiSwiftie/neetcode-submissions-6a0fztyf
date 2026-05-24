class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] par = new int[n];
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            par[i] = i;
            rank[i] = 1;
        }
        int res = n;
        for (int[] edge : edges) {
            if (union(par, rank, edge[0], edge[1])) {
                res--;
            }
        }
        return res;
    }

    private int find(int[] par, int node) {
        int cur = node;
        while (cur != par[cur]) {
            par[cur] = par[par[cur]];
            cur = par[cur];
        }
        return cur;
    }

    private boolean union(int[] par, int[] rank, int n1, int n2) {
        int p1 = find(par, n1), p2 = find(par, n2);
        if (p1 == p2) {
            return false;
        }
        if (rank[p1] > rank[p2]) {
            rank[p1] += rank[p2];
            par[p2] = p1;
        } else {
            rank[p2] += rank[p1];
            par[p1] = p2;
        }
        return true;
    }
}
