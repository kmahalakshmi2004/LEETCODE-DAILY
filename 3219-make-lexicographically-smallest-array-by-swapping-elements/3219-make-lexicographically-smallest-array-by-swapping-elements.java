class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int[] numsSorted = nums.clone();
        Arrays.sort(numsSorted);

        int grpCurr = 0;
        HashMap<Integer, Integer> ntog = new HashMap<>();
        HashMap<Integer, LinkedList<Integer>> gtol = new HashMap<>();
        ntog.put(numsSorted[0], grpCurr);
        gtol.put(grpCurr, new LinkedList<>(List.of(numsSorted[0])));

        for (int i = 1; i < numsSorted.length; i++) {
            if (numsSorted[i] - numsSorted[i - 1] <= limit) {
                gtol.get(grpCurr).add(numsSorted[i]);
                ntog.put(numsSorted[i], grpCurr);
            } else {
                grpCurr++;
                gtol.put(grpCurr, new LinkedList<>(List.of(numsSorted[i])));
                ntog.put(numsSorted[i], grpCurr);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = gtol.get(ntog.get(nums[i])).remove();
        }

        return nums;
    }
}