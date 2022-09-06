class Solution {
    public int searchInsert(int[] nums, int target) {
        
        int index = 0;
        
        if(nums.length==0)
            return 0;
        
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i]==target)
                index = i;
            
            else if(target>nums[i])
            {
                index++;
            }
        }
        return index;
    }
}