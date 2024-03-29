class Solution {
    // 509. Fibonacci Number
    // https://leetcode.com/submissions/detail/739658819/
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int[] fibo = new int[n + 1];
        fibo[0] = 0;
        fibo[1] = 1;

        for (int i = 2; i <= n; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }

        return fibo[n];

        // //base case
        // if(n==0)
        // return 0;
        // if(n==1)
        // return 1;

        // int ans = fib(n-1) + fib (n-2);

        // return ans;
    }
}