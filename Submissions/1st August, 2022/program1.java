class Solution {
    // https://leetcode.com/problems/longest-increasing-subsequence/
    public int lengthOfLIS(int[] nums) {
        int[] sub = new int[nums.length];
        sub[0] = nums[0];
        int currentIndex = 0;
        int maxLength = currentIndex;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > sub[currentIndex]) {
                sub[++currentIndex] = nums[i];
                maxLength = Math.max(maxLength, currentIndex);
            } else {
                int j = 0;
                while (sub[j] < nums[i]) {
                    j++;
                }
                sub[j] = nums[i];
            }
        }
        return maxLength + 1;
    }
}