class Solution {
    // 746. Min Cost Climbing Stairs
    // https://leetcode.com/submissions/detail/743100572/
    public int minCostClimbingStairs(int[] cost) {
         int[] mem = new int[cost.length];
        mem[0]=cost[0];
        mem[1]=cost[1];
        for(int i=2;i<cost.length;i++) {
            mem[i]=cost[i]+Math.min(mem[i-1],mem[i-2]);
        }
        return Math.min(mem[cost.length-1],mem[cost.length-2]);
//          if (cost.length == 2) // base
//             return Math.min(cost[0], cost[1]);
        
//         int[] dp = new int[cost.length + 1]; // the one for the top
//         dp[0] = 0; dp[1] = 0; // we can reach index 0 or 1 freely
        
//         for (int i = 2; i < dp.length; i++) {
// 			// To reach index i, the prev index could only be i - 2 or i - 1. Note: you should add the cost of climb
//             dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]); 
//         }
        
//         return dp[dp.length - 1];
    }
}