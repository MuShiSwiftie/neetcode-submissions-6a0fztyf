class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(0, 0, n, res, new StringBuilder());
        return res;
    }

    private void backtrack(int open, int closed, int n, List<String> res, StringBuilder sb) {
        if (open == closed && open == n) {
            res.add(sb.toString());
            return;
        }
        if (open < n) {
            sb.append('(');
            backtrack(open + 1, closed, n, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (closed < n && closed < open) {
            sb.append(')');
            backtrack(open, closed + 1, n, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
