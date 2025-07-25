class Solution:
    def maxSum(self, nums: List[int]) -> int:

        # check if all are negative
        mn = float('-inf')
        pos = False
        for val in nums:
            if val > 0:
                pos = True
                break
            mn = max(mn, val)

        if not pos:
            return mn

        # else answer will always a positive number or 0
        seen = set()
        sum_ = 0

        for val in nums:
            if val >= 0:
                if val not in seen:
                    if val >= 0:
                        sum_ += val
                seen.add(val)

        return sum_