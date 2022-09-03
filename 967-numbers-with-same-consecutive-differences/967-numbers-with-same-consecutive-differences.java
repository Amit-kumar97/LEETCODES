class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        
        List<Integer> list = new ArrayList();
        
        for(int i=1; i<10; i++)
            dfs(i, i, n-1, k, list);
        
        int[] ans = new int[list.size()];
        
        for(int i=0; i<ans.length; i++)
            ans[i] = list.get(i);
        
        return ans;
    }
    private void dfs(int num, int digit, int n, int k, List<Integer> list)
    {
        if(n==0)
        {
            list.add(num);
            return;
        }
        if(digit+k <= 9)
            dfs(num*10+(digit+k), digit+k, n-1, k, list);
        
        if(k!=0 && digit-k >= 0)
            dfs(num*10+(digit-k), digit-k, n-1, k, list);   
    }

}