class Solution {
    public int combinationSum4(int[] nums, int target) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 1);

        for (int i = 1; i <= target; i++) {
            dp.put(i, 0);
            for (int num : nums) {
                dp.put(i, dp.get(i) + dp.getOrDefault(i - num, 0));
            }
        }

        return dp.get(target);
    }
}