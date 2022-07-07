class Solution {
    // 135. Candy
    // https://leetcode.com/submissions/detail/737919951/
    // https://leetcode.com/problems/candy/discuss/2234860/3ms-on-time-complexity-java-extremely-simple-intuition
    public int candy(int[] r) {
/*       
sample test case : [3,2,1,2,3,0] 
eexpected answer : 15 candies
.-----------------------.---.---.---.---.---.---.---.---.
|         index         | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 |
:-----------------------+---+---+---+---+---+---+---+---:
| values of test case   | 3 | 2 | 1 | 2 | 3 | 2 | 3 | 0 |
:-----------------------+---+---+---+---+---+---+---+---:
| forward pass   ->     | 1 | 1 | 1 | 2 | 3 | 1 | 2 | 1 | //values in A[] array
:-----------------------+---+---+---+---+---+---+---+---:
| backward pass  <-     | 3 | 2 | 1 | 1 | 2 | 1 | 2 | 1 | //values in B[] array
:-----------------------+---+---+---+---+---+---+---+---:
| candies at each index | 3 | 2 | 1 | 2 | 3 | 1 | 2 | 1 | //max values A and B combined
'-----------------------'---'---'---'---'---'---'---'---'
        
 forward pass : for targeting strictly increasing ratings 
 backward pass : for targeting strictly increasing ratings from the other side
        
*/        
        int n=r.length;
        if(n==0) return 0;
        if(n==1) return 1;
        
        int[] c=new int[n]; 
        c[0]=1;
        for(int i=1;i<n;i++)//forward pass
        {
            if(r[i]>r[i-1]) c[i]=c[i-1]+1;
            else c[i]=1;
        }
        for(int i=n-2;i>=0;i--)//backward pass
        {
            if(r[i]>r[i+1]) 
                if(c[i]<c[i+1]+1) c[i]=c[i+1]+1 ;
        } 
        int s=0;
        for(int i:c)
            s+=i;
        return s;
    }
}