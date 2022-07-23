class Solution {
    //https://leetcode.com/problems/count-of-smaller-numbers-after-self
    //315. Count of Smaller Numbers After Self
    private int maxN = (int) 2e4 + 9;
    private int[] bit = new int[maxN];
    private int offset = (int) 1e4 + 1;
    private int low_bit(int x) {
        return x & -x;
    }
    
    private void edit(int ind, int delta) {
        for (int i = ind; i < maxN; i += low_bit(i)) {
            bit[i] += delta;
        }
    }
    
    private int query(int ind) {
        int result = 0;
        for (int i = ind; i > 0; i -= low_bit(i)) {
            result += bit[i];
        }
        
        return result;
    }
    
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        Integer[] answer = new Integer[n];
        
        for (int i = n - 1; i >= 0; i--) {
            edit(nums[i] + offset, 1);
            answer[i] = query(nums[i] + offset - 1);
        }
        
        return Arrays.asList(answer);
    }
}

/* BIT. 
go from right to left, query # of smaller, and then add myself to BIT
need to offset so that nums start at 1 
time O(nlogn)
space O(maxN) for the bit[] array
*/



// class Solution {
    
//     int offset = (int)1e4;
//     public List<Integer> countSmaller(int[] nums) {
        
//         BIT sol = new BIT(); 
//         List<Integer> res = new ArrayList<>();
//         for(int i = nums.length - 1; i >= 0; i--) {
//             res.add(sol.get(nums[i] - 1 + offset));
//             sol.update(nums[i] + offset);
//         }
//         Collections.reverse(res);
//         return res;
//     }
    
//     class BIT {
//         int[] c;
//         int m;
//         BIT() {
//             m = offset + 1 + offset + 1;
//             c = new int[m];
//         }
        
//         public void update(int idx) {
//             idx++;
//             while(idx < m) {
//                 c[idx]++;
//                 idx += idx & -idx;
//             }
//         }
        
//         public int get(int idx) {
//             idx++;
//             int sum = 0;
//             while(idx > 0) {
//                 sum += c[idx];
//                 idx -= idx & -idx;
//             }
//             return sum;
//         }
//     }
    
//     class SegTree {
//         int[] tree;
//         int m;
//         SegTree() {
//             m = offset + 1 + offset + 1;
//             tree = new int[m * 2];
//         }
        
//         public void update(int idx) {
//             idx += m;
//             tree[idx]++;
//             for( idx >>= 1; idx > 0; idx >>= 1) {
//                 tree[idx] = tree[idx << 1] + tree[(idx << 1) | 1];
//             }
//         }
        
//         public int get(int idx) {
//             return get(0, idx);
//         }
        
//         public int get(int l, int r) {
//             l += m;
//             r += m;
//             int sum = 0;
//             while(l <= r) {
//                 if ((l & 1) == 1) {
//                     sum += tree[l++];
//                 }
//                 if ((r & 1) == 0) {
//                     sum += tree[r--];
//                 }
//                 l >>= 1;
//                 r >>= 1;
//             }
//             return sum;
//         }
//     }
// }



// // class Solution {
// //     public List<Integer> countSmaller(int[] nums) { 
        
        
        
// //         //Better  approach
// // //         int min = 20001;
// // //         int max = -1;
// // //         for (int num : nums) {
// // //             min = Math.min(min, num);
// // //             max = Math.max(max, num);
// // //         }
        
// // //         min--;
// // //         int[] count = new int[max-min+1];
// // //         Integer[] result = new Integer[nums.length];
// // //         for (int i = nums.length-1; i >=0; i--) {
// // //             int k = nums[i]-min-1;
// // //             int c = 0;
// // //             do {
// // //                 c += count[k];
// // //                 k -= (-k&k);
// // //             } while (k > 0);
// // //             result[i] = c;
            
// // //             k = nums[i]-min;
// // //             while (k < count.length) {
// // //                 count[k]++;
// // //                 k += (-k&k);
// // //             }
// // //         }
        
// // //         return Arrays.asList(result);
        
        
// //         //Naive approach
// // //         int ans[]=new int[nums.length];
// // //         Arrays.fill(ans,0);
// // //         for(int i=nums.length-2;i>=0;i--)
// // //         { 
// // //             for(int j=i+1;j<nums.length;j++)
// // //             {
// // //                 if(nums[j]<nums[i]) ans[i]++;
// // //             }
// // //         } 
        
// // //         List<Integer> res = new ArrayList<Integer>(); 
// // //         for (int i : ans)
// // //         {
// // //             res.add(i);
// // //         }
// // //         return res;
// //     }
// // }