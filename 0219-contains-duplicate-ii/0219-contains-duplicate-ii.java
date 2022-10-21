class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k==0)
            return false;
        
        Set<Integer> window = new HashSet<>();
        
        for(int index=0; index<nums.length; index++){
            if(window.contains(nums[index]))
                return true;
            
            if(index>=k)
                window.remove(nums[index-k]);

            window.add(nums[index]);
        }
        return false;
    }
}