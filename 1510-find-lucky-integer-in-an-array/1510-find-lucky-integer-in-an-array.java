class Solution {
    public static int findLucky(int[] numbers) {  // \U0001f3a3 Let's start our lucky number hunt!
        int[] freq = new int[501];             // \U0001f4e6 This is our frequency counter! Think of it like a shelf for each number from 0 to 500.

        for (int num : numbers) freq[num]++;   // \U0001f6b6‍♀️ We're strolling through our number line-up...
                                               //    ...and for each number, we bump up its counter on our frequency shelf.

        for (int i = 500; i > 0; i--)         // \U0001f50e Okay, time to check from biggest to smallest if anyone's lucky!
            if (i == freq[i]) return i;      // \U0001f340 Found a lucky one! This number (i) appears exactly i times!

        return -1;                              // \U0001f494 Aww, no lucky numbers this time. Returning -1.
    }
}