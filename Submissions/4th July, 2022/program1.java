class Solution { // https://leetcode.com/submissions/detail/740774631/
    public boolean isInterleave(String s1, String s2, String s3) {
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray(), c3 = s3.toCharArray();
        int l1 = c1.length, l2 = c2.length;
        if (l1 + l2 != c3.length) {
            return false;
        }
        return dfs(c1, c2, c3, 0, 0, 0, new boolean[l1 + 1][l2 + 1]);
    }

    private boolean dfs(char[] c1, char[] c2, char[] c3, int i, int j, int k, boolean[][] invalid) {
        if (invalid[i][j])
            return false;
        if (k == c3.length)
            return true;
        boolean valid = i < c1.length && c1[i] == c3[k] && dfs(c1, c2, c3, i + 1, j, k + 1, invalid) ||
                j < c2.length && c2[j] == c3[k] && dfs(c1, c2, c3, i, j + 1, k + 1, invalid);

        if (!valid) {
            invalid[i][j] = true;
        }
        return valid;
    }

    // 3D DP
    // Boolean[][][] dp;
    // public boolean isInterleave(String s1, String s2, String s3) {

    // int s1Len = s1.length(), s2Len = s2.length(), s3Len = s3.length();

    // dp = new Boolean[s1Len+1][s2Len+1][s3Len+1];

    // // If length of s1 + s2 is not equal with that of s3 then return false bcz s3
    // is created by combining s1 and s2 only
    // if((s1Len+s2Len) != s3Len) return false;

    // return solve(s1,s2,s3,0,0,0);
    // }

    // private boolean solve(String s1, String s2, String s3, int i1, int i2, int
    // j){

    // // Base condition
    // if(j == s3.length()) return true;

    // if(dp[i1][i2][j] != null) return dp[i1][i2][j];

    // // If any of string (s1 or s2) ends, then continue comparing with the
    // remaining string
    // if(i1 == s1.length() && i2 != s2.length())
    // return dp[i1][i2][j] = (s2.charAt(i2)==s3.charAt(j)) &&
    // solve(s1,s2,s3,i1,i2+1,j+1);
    // else if(i1 != s1.length() && i2 == s2.length())
    // return dp[i1][i2][j] = (s1.charAt(i1)==s3.charAt(j)) &&
    // solve(s1,s2,s3,i1+1,i2,j+1);

    // char s1C = s1.charAt(i1), s2C = s2.charAt(i2), s3C = s3.charAt(j);

    // // If char of s1 matches with s3 but not of s2
    // if(s1C == s3C && s2C != s3C)
    // return dp[i1][i2][j] = solve(s1,s2,s3,i1+1,i2,j+1);

    // // If char of s2 matches with s3 but not of s1
    // else if (s1C != s3C && s2C == s3C)
    // return dp[i1][i2][j] = solve(s1,s2,s3,i1,i2+1,j+1);

    // // If char of both s1 and s2 matches with s3
    // else if(s1C == s3C && s2C == s3C)
    // return dp[i1][i2][j] = solve(s1,s2,s3,i1,i2+1,j+1) ||
    // solve(s1,s2,s3,i1+1,i2,j+1);

    // // If no char of either s1 or s2 matching with s3, then return false as the
    // char in s3 is not a part of any substring of s1 and s2
    // else return dp[i1][i2][j] = false;
    // }
}