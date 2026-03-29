class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (s1Count[i] == s2Count[i]) {
                matches++;
            }
        }

        int l = 0;
        for (int r = s1.length(); r < s2.length(); r++) {
            if (matches == 26) {
                return true;
            }

            int rIndex = s2.charAt(r) - 'a';
            s2Count[rIndex]++;
            if (s2Count[rIndex] == s1Count[rIndex]) {
                matches++;
            } else if (s1Count[rIndex] + 1 == s2Count[rIndex]) {
                matches--;
            }

            int lIndex = s2.charAt(l) - 'a';
            s2Count[lIndex]--;
            if (s1Count[lIndex] == s2Count[lIndex]) {
                matches++;
            } else if (s1Count[lIndex] - 1 == s2Count[lIndex]){
                matches--;
            }
            l++;
        }
        return matches == 26;
    }
}
