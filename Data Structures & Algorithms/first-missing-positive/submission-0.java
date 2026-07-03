class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        boolean hasOne = false;
        for (int num : nums) {
            if (num == 1) {
                hasOne = true;
                break;
            }
        }

        if (!hasOne) {
            return 1;
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = 1;
            }
        }

        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1;

            nums[index] = -Math.abs(nums[index]);
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        return n + 1;
    }
}