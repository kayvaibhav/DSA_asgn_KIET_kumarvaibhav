class Solution {
    // https://leetcode.com/problems/out-of-boundary-paths/
    // 576. Out of Boundary Paths
    int[][][] cache;
    int MOD = 1000_000_007;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        cache = new int[m][n][maxMove + 1];
        for (int[][] cc : cache) {
            for (int[] c : cc) {
                Arrays.fill(c, -1);
            }
        }
        return f(m, n, maxMove, startRow, startColumn);
    }

    int f(int m, int n, int max, int r, int c) {
        if (r < 0 || c < 0 || r == m || c == n) {
            return 1;
        }
        if (max == 0) {
            return 0;
        }
        if (cache[r][c][max] > -1) {
            return cache[r][c][max];
        }
        long l = f(m, n, max - 1, r - 1, c) % MOD;
        l += f(m, n, max - 1, r + 1, c) % MOD;
        l += f(m, n, max - 1, r, c + 1) % MOD;
        l += f(m, n, max - 1, r, c - 1) % MOD;
        cache[r][c][max] = (int) (l % MOD);
        return cache[r][c][max];
    }
}

// class Solution {
// Long[][][] memo = null;
// long mod = 1000000007;
// public int findPaths(int m, int n, int maxMove, int startRow, int
// startColumn) {
// memo = new Long[m+1][n+1][maxMove+1];
// return (int) findPathsHelper(m, n, maxMove, startRow, startColumn);
// }
// public long findPathsHelper(int m, int n, int maxMove, int row, int col) {
// if(maxMove < 0) return 0;
// if(row == m || col == n || row < 0 || col < 0) return 1;
// if(memo[row][col][maxMove] != null) return memo[row][col][maxMove];

// long leftPaths = findPathsHelper(m, n, maxMove-1, row-1, col);
// long rightPaths = findPathsHelper(m, n, maxMove-1, row+1, col);
// long topPaths = findPathsHelper(m, n, maxMove-1, row, col-1);
// long bottomPaths = findPathsHelper(m, n, maxMove-1, row, col+1);

// return memo[row][col][maxMove] =
// (leftPaths+rightPaths+topPaths+bottomPaths)%mod;
// }
// }