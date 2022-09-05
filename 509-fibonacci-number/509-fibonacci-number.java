class Solution {
    public int fib(int n) {
        
        if(n==0)
            return 0;
        
        return fibb(new int[n+1], n);
    }
    
    private int fibb(int[] memo, int n)
    {
        if(memo[n]==0)
        {
            if(n<2)
                memo[n] = n;
            else
            {
                int left = fibb(memo, n-1);
                int right = fibb(memo, n-2);
                memo[n] = left+right;
            }
        }
        return memo[n];
    }
}