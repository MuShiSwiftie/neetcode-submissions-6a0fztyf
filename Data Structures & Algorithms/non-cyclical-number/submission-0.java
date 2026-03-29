class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (!set.contains(n)) {
            set.add(n);
            n = sumOfSquares(n);
            if (n == 1) {
                return true;
            }
        }
        return false;
    }

    private int sumOfSquares(int n) {
        int output = 0;
        while (n > 0) {
            int digit = n % 10;
            output += Math.pow(digit, 2);
            n /= 10;
        }
        return output;
    }
}
