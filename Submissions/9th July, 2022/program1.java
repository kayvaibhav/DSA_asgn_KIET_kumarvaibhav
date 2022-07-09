class Solution {
    // https://leetcode.com/submissions/detail/742270925/
    // 1696. Jump Game VI
    public int maxResult(int[] nums, int k) {
        int[] ar = new int[nums.length];
        ar[0] = nums[0];
        int max = nums[0], maxidx = 0;
        for (int i = 1; i < nums.length; i++) {
            if (i - k <= 0 || maxidx >= i - k) {
                ar[i] = max + nums[i];
                if (ar[i] >= max) {
                    max = ar[i];
                    maxidx = i;
                }
            } else {
                max = ar[i - k];
                maxidx = i - k;
                for (int j = i - k + 1; j < i; j++) {
                    if (ar[j] >= max) {
                        max = ar[j];
                        maxidx = j;
                    }
                }
                ar[i] = max + nums[i];
                if (ar[i] >= max) {
                    max = ar[i];
                    maxidx = i;
                }
            }
        }
        return ar[nums.length - 1];

        // PriorityQueue<int[]> pq=new PriorityQueue<int[]>((a,b)->b[0]-a[0]);
        // pq.add(new int[]{nums[0],0});
        // int res=nums[0];
        // for(int i=1;i<nums.length;i++){
        // while(pq.peek()[1]<(i-k))
        // pq.poll();
        // pq.add(new int[]{res=nums[i]+pq.peek()[0],i});
        // }
        // return res;
    }
}