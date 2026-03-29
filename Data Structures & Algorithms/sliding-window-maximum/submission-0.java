class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] output = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        int l = 0, r = 0;
        while (r < nums.length) {
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[r]) {
                deque.removeLast();
            }
            deque.addLast(r);
            if (l > deque.getFirst()) {
                deque.removeFirst();
            }
            if ((r + 1) >= k) {
                output[l] = nums[deque.getFirst()];
                l++;
            }
            r++;
        }
        return output;
    }
}
