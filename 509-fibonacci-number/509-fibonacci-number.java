class Solution {
    public int fib(int n) {
        
        if(n<=1)
            return n;
        
        if(n==2)
            return 1;
        
        int current = 0;
        int prev1 = 1;
        int prev2 = 1;
        
        for(int i=3; i<=n; i++)
        {
            current = prev1+prev2;
            prev1 = prev2;
            prev2 = current;
        }
        
        return current;
    }
}