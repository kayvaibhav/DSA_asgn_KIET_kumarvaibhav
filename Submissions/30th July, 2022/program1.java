class Solution {
    // https://leetcode.com/problems/number-of-arithmetic-triplets/

    public int arithmeticTriplets(int[] nums, int diff) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            int greater = nums[i] + diff;
            int lesser = nums[i] - diff;

            if (set.contains(greater) && set.contains(lesser)) {
                ans++;
            }
        }
        return ans;
    }
}