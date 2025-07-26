from typing import List

class Solution:
    def maxSubarrays(self, n: int, conflictingPairs: List[List[int]]) -> int:
        # Step 1: Create a list where right[r] holds all 'l' such that (l, r) is a conflicting pair
        right = [[] for _ in range(n + 1)]
        for a, b in conflictingPairs:
            # Always store smaller as l, larger as r
            right[max(a, b)].append(min(a, b))

        # Step 2: Initialize
        ans = 0  # Total number of valid subarrays
        left = [0, 0]  # left[0] = max left that causes conflict, left[1] = second max
        bonus = [0] * (n + 1)  # bonus[i] = how many subarrays we regain if we remove conflict involving i

        # Step 3: Traverse from 1 to n
        for r in range(1, n + 1):
            # For each conflicting pair ending at r
            for l in right[r]:
                # Update max and second max conflicting lefts
                if l > left[0]:
                    left[1] = left[0]
                    left[0] = l
                elif l > left[1]:
                    left[1] = l

            # Count valid subarrays ending at r
            ans += r - left[0]

            # Store bonus: if we remove left[0], how many subarrays are restored?
            if left[0] > 0:
                bonus[left[0]] += left[0] - left[1]

        # Step 4: Add the best possible bonus
        return ans + max(bonus)