class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        List<Integer>[] bucket = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int f = entry.getValue();
            if (bucket[f] == null) bucket[f] = new ArrayList<>();
            bucket[f].add(entry.getKey());
        }

        int[] res = new int[k];
        int idx = 0;
        for (int i = bucket.length - 1; i > 0 && idx < k; i--) {
            if (bucket[i] == null) {
                continue;
            }
            for (int num : bucket[i]) {
                res[idx++] = num;
                if (idx == k) {
                    break;
                }
            }
        }
        return res;
    }
}
