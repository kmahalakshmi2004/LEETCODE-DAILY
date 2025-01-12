class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if (n % 2 == 1) return false;
        int b = 0, a = 0;
        for (int i = 0; i < n; i++) {
            b += (locked.charAt(i) == '0' || s.charAt(i) == '(') ? 1 : -1;
            if (b < 0) return false;
            a += (locked.charAt(n - i - 1) == '0' || s.charAt(n - i - 1) == ')') ? 1 : -1;
            if (a < 0) return false;
        }
        return true;
    }
}