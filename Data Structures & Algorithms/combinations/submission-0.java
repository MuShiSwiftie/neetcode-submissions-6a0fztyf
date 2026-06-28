class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(n, k, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int n, int k, int cur, List<Integer> comb, List<List<Integer>> res) {
        if (comb.size() == k) {
            res.add(new ArrayList<>(comb));
            return;
        }
        for (int i = cur; i < n; i++) {
            comb.add(i + 1);
            backtrack(n, k, i + 1, comb, res);
            comb.remove(comb.size() - 1);
        }
    }
}