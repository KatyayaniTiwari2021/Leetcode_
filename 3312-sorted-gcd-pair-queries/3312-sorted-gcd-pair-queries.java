class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {

        int max = 0;
        for (int x : nums) {
            max = Math.max(max, x);
        }

        // freq[i] = frequency of number i
        int[] freq = new int[max + 1];

        for (int x : nums) {
            freq[x]++;
        }

        // exact[i] = number of pairs whose gcd is exactly i
        long[] exact = new long[max + 1];

        // Traverse from largest gcd to smallest
        for (int g = max; g >= 1; g--) {

            long cnt = 0;

            // Count numbers divisible by g
            for (int multiple = g; multiple <= max; multiple += g) {
                cnt += freq[multiple];
            }

            // Total pairs having gcd >= g
            exact[g] = cnt * (cnt - 1) / 2;

            // Remove pairs whose gcd is 2g,3g,...
            for (int multiple = 2 * g; multiple <= max; multiple += g) {
                exact[g] -= exact[multiple];
            }
        }

        // Prefix sum
        long[] prefix = new long[max + 1];

        for (int i = 1; i <= max; i++) {
            prefix[i] = prefix[i - 1] + exact[i];
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            long q = queries[i];

            int left = 1;
            int right = max;

            while (left < right) {

                int mid = left + (right - left) / 2;

                if (prefix[mid] > q) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            ans[i] = left;
        }

        return ans;
    }
}