class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(new ArrayList<>(), nums, new boolean[nums.length], res);
        return res;
    }

    private void backtrack(List<Integer> perm, int[] nums, boolean[] picked, List<List<Integer>> res) {
        if (perm.size() == nums.length) {
            res.add(new ArrayList<>(perm));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!picked[i]) {
                perm.add(nums[i]);
                picked[i] = true;
                backtrack(perm, nums, picked, res);
                picked[i] = false;
                perm.remove(perm.size() - 1);
            }
        }
    }
}
