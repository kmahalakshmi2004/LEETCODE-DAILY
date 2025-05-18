class Solution {
public:
    int lengthOfLastWord(string s) {
        int count = 0;
        int n = s.length();
        
        // Traverse the string from the end
        for (int i = n - 1; i >= 0; i--) {
            // If the current character is a space and count is greater than 0, break
            if (s[i] == ' ' && count > 0) {
                break;
            }
            // If the current character is not a space, increment the count
            if (s[i] != ' ') {
                count++;
            }
        }
        
        return count;
    }
};