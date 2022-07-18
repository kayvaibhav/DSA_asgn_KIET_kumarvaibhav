class Solution {
    // https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/
    // 1074. Number of Submatrices That Sum to Target
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int res = 0;
        
        // traverse upper boundary
        for (int top = 0; top < m; top++) {
            
            // for each upper boundary, we have a prefix sum array
            int[] sum = new int[n];
            
            // traverse lower boundary
            for (int bottom = top; bottom < m; bottom++) {
                
                // count the prefix sum for each column
                for (int col = 0; col < n; col++) {
                    sum[col] += matrix[bottom][col];
                }
          
                // traverse left and right boundary
                for (int left = 0; left < n; left++) {
                    int cnt = 0;
                    for (int right = left; right < n; right++) {
                        cnt += sum[right];
                        if (cnt == target) res++;
                    }
                }
            }
        }
        return res;
    }
}



// class Solution {
//     public int numSubmatrixSumTarget(int[][] matrix, int target) {
//         int n=matrix.length;
//         int m=matrix[0].length;
//         long dp[][]=new long[n][m];
//         for(int i=0;i<n;i++)
//         {
//             dp[i][0]=matrix[i][0];
//         }
//         for(int i=0;i<n;i++)
//         {
//             for(int j=1;j<m;j++)
//             {
//                 dp[i][j]=dp[i][j-1]+matrix[i][j];
//             }
//         }
//         int count=0;
//         for(int start=0;start<m;start++)
//         {
//             for(int end=start;end<m;end++)
//             {
//                 HashMap<Long,Integer> map=new  HashMap<Long,Integer>();
//                 long sum=0;
//                 for(int i=0;i<n;i++)
//                 {
//                     map.put(sum,map.getOrDefault(sum,0)+1);
//                     long pre=start!=0?dp[i][start-1]:0;
//                     sum+=dp[i][end]-pre;
//                     if(map.containsKey(sum-target))
//                     {
//                         count+=map.get(sum-target);
//                     }
//                 }
//             }
//         }
//         return count;
        
//     }
// }