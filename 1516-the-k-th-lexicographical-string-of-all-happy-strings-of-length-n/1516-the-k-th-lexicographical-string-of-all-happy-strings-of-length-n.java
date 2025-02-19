class Solution {
    static int count = 0;
    static String res = "";
    public String getHappyString(int n, int k) {
        count = 0;
        res = "";
        backtrack(n, k, new StringBuilder(), ' ');
        return res;
    }

    private static void backtrack(int n, int k, StringBuilder sb, char lastChar) {
        if(sb.length() == n) {
            if(++count == k) {
                res = sb.toString();
            }
            return;
        }

        char[] chars = {'a', 'b', 'c'};
        for(int i = 0 ; i < chars.length ; i++) {
            char c = chars[i];
            if(c != lastChar) {
                sb.append(c);
                backtrack(n,k,sb,c);
                sb.setLength(sb.length()-1);
                if(!res.isEmpty()) return; 
            }   
        }
    }
}