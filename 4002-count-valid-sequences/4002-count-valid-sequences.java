class Solution {

    static int MOD = 1_000_000_007;

    public int countValidSequences(int n, int k) {

        long[] factorial = new long[n+1];

        factorial[0] = 1;  //factorial of 0 = 1 hota hai

        for(int i = 1; i <= n; i++){
            factorial[i] = (factorial[i-1]*i) % MOD;
        }

        //total sequence = (n-1) C (k-1);

        long total = combination(n-1, k-1, factorial);

        //total odd 

        long odd = 0;

        if((n-k) % 2 == 0){
            int top = (n + k - 2)/2;

            odd = combination(top, k - 1, factorial);
        }

        return ((int)(total - odd + MOD )) % MOD;




        
    }

    private long combination(int n, int k, long[] factorial){

        if(k > n || k < 0) return 0;

        long numerator = factorial[n];
        long demonator = (factorial[k] * factorial[n-k]) % MOD;

        long inverse = power(demonator, MOD - 2);

        return  (numerator * inverse) % MOD;

    }

    private long power(long a, long b){
        long ans = 1;

        while(b > 0){

            if((b & 1) == 1){
                ans =  (ans *a) % MOD;

            }
            a = (a *a) % MOD;
            b >>= 1;

        }
        return ans;
    }
}