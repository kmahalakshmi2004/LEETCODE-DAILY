long long countSteps(long long n, long long curr, long long next) {
    long long steps = 0;
    while (curr <= n) {
        steps += (next <= n + 1 ? next : n + 1) - curr;
        curr *= 10;
        next *= 10;
    }
    return steps;
}

int findKthNumber(int n, int k) {
    int curr = 1;
    k--;

    while (k > 0) {
        long long steps = countSteps(n, curr, curr + 1);
        if (steps <= k) {
            curr++;
            k -= steps;
        } else {
            curr *= 10;
            k--;
        }
    }

    return curr;
}