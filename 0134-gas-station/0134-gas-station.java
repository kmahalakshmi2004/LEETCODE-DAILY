class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total_tank = 0, curr_tank = 0, start_index = 0;
        for (int i = 0; i < gas.length; i++) {
            total_tank += gas[i] - cost[i];
            curr_tank += gas[i] - cost[i];
            if (curr_tank < 0) {
                start_index = i + 1;
                curr_tank = 0;
            }
        }
        return (total_tank >= 0) ? start_index : -1;
    }
}