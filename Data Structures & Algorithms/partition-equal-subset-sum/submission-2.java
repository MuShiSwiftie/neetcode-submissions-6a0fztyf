class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        Set<Integer> dp = new HashSet<>();
        dp.add(0);
        int target = sum / 2;
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> nextDp = new HashSet<>();
            for (int t : dp) {
                if (t + nums[i] == target) {
                    return true;
                }
                nextDp.add(t);
                nextDp.add(t + nums[i]);
            }
            dp = nextDp;
        }
        return false;
    }
}
