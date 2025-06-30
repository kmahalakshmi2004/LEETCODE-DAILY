import java.util.*;

class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> hash = new HashMap<>();
        int longest = 0;
        for (int num : nums) {
            hash.put(num, hash.getOrDefault(num, 0) + 1);
        }
        for (int key : hash.keySet()) {
            if (hash.containsKey(key + 1)) {
                longest = Math.max(longest, hash.get(key) + hash.get(key + 1));
            }
        }
        return longest;
    }
}