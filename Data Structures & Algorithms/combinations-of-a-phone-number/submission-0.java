class Solution {
    private String[] digitToChar = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;
        dfs(0, digits, new StringBuilder(), res);
        return res;
    }

    private void dfs(int i, String digits, StringBuilder sb, List<String> res) {
        if (i == digits.length()) {
            res.add(sb.toString());
            return;
        }

        for (char c : digitToChar[digits.charAt(i) - '0'].toCharArray()) {
            sb.append(c);
            dfs(i + 1, digits, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
