class Solution {
    public int myAtoi(String s) {
        // Your code here
        int sign = 1, res = 0, idx = 0;

        // white spaces are excluded
        while (idx < s.length() && s.charAt(idx) == ' ') {
            idx++;
        }

        // finding the sign
        if (idx < s.length() && (s.charAt(idx) == '-' || s.charAt(idx) == '+')) {
            sign = (s.charAt(idx) == '-') ? -1 : 1;
            idx++; 
        }

        if (idx >= s.length() || !Character.isDigit(s.charAt(idx))) {
            return 0;
        }
        // making the integer

        while (idx < s.length() && s.charAt(idx) >= '0' && s.charAt(idx) <= '9') {

            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && s.charAt(idx) - '0' > 7)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = 10 * res + (s.charAt(idx++) - '0');
        }
        return res * sign;

    }
}