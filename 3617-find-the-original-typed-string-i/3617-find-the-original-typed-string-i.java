class Solution {
    public int possibleStringCount(String word) {
        int res = 1;
        int i = 0, l = word.length(), val;
        char cur;
        while (i < l) {
            val = 1;
            cur = word.charAt(i);
            while (i < l - 1 && cur == word.charAt(i + 1)) {
                val++;
                i++;
            }
            i++;
            res += val - 1;
        }
        return res;
    }
}