class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];

        int res = 0, maxFrequency = 0, l = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            count[c - 'A']++;

            maxFrequency = Math.max(maxFrequency, count[c - 'A']);
            while (r - l + 1 - maxFrequency > k) {
                count[s.charAt(l) - 'A']--;
                l++;
            }

            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
