class Solution {
    // 128. Longest Consecutive Sequence
    // https://leetcode.com/submissions/detail/738778250/
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        radixSort(nums, 0, nums.length);

        int longestSubsequenceLength = 0;
        int curSubsequenceLength = 1;
        int previousNum = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == previousNum + 1) {
                ++curSubsequenceLength;
                ++previousNum;
            } else if (nums[i] != previousNum) {
                longestSubsequenceLength = Math.max(curSubsequenceLength, longestSubsequenceLength);
                curSubsequenceLength = 1;
                previousNum = nums[i];
            }
        }
        longestSubsequenceLength = Math.max(curSubsequenceLength, longestSubsequenceLength);

        return longestSubsequenceLength;

        // Arrays.sort(nums);
        // if(nums.length == 0) return 0;
        // int count = 1;
        // int maxi = 1;
        // for(int i=1; i<nums.length; i++){
        // if(nums[i-1]==nums[i]) continue;
        // else if(nums[i-1]+1 == nums[i]) count += 1;
        // else count = 1;

        // maxi = Math.max(maxi, count);
        // }

        // return maxi;
    }

    public static void radixSort(final int[] arr, final int leftIdx, final int rightIdx) {
        final int bitsInByte = 8;
        final int intBytes = 4;
        final int byteSize = 1 << bitsInByte;
        final int byteMask = byteSize - 1;
        final int size = rightIdx - leftIdx;

        final int[] aux = new int[size];
        final int[] counts = new int[byteSize + 1];

        for (int byteIdx = 0; byteIdx < intBytes; ++byteIdx) {
            Arrays.fill(counts, 0);
            for (int i = leftIdx; i < rightIdx; ++i) {
                final int byteValue = (arr[i] >> bitsInByte * byteIdx) & byteMask;
                ++counts[byteValue + 1];
            }

            for (int i = 0; i < byteSize; ++i) {
                counts[i + 1] += counts[i];
            }

            if (byteIdx == intBytes - 1) {
                final int halfByteSize = byteSize >> 1;
                final int shift1 = counts[byteSize] - counts[halfByteSize];
                final int shift2 = counts[halfByteSize];
                for (int i = 0; i < halfByteSize; ++i) {
                    counts[i] += shift1;
                }
                for (int i = halfByteSize; i < byteSize; ++i) {
                    counts[i] -= shift2;
                }
            }

            for (int i = leftIdx; i < rightIdx; ++i) {
                final int byteValue = (arr[i] >> bitsInByte * byteIdx) & byteMask;
                aux[counts[byteValue]] = arr[i];
                ++counts[byteValue];
            }

            System.arraycopy(aux, 0, arr, leftIdx, size);
        }
    }
}