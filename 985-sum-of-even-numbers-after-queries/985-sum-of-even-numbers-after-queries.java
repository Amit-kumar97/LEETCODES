class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] q) {
        int[] ar_New = new int[nums.length];
        int sum = 0;
        for(int i=0;i<nums.length; i++)
        {
            if(nums[i]%2==0)
                sum += nums[i];
        }
        for(int i=0; i<q.length; i++)
        {
            if(nums[q[i][1]]%2==0)
            {
                if(q[i][0]%2==0)
                    sum += q[i][0];
                else
                    sum -= nums[q[i][1]];
            }
            else{
                if(q[i][0]%2==0){
                    
                }
                else
                    sum += nums[q[i][1]]+q[i][0];
            }
            nums[q[i][1]] += q[i][0];
            ar_New[i] = sum;
        }
        return ar_New;
    }
}