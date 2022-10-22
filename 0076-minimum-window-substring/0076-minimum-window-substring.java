class Solution {
    public String minWindow(String s, String t) {
        
        int m = s.length();
        int n = t.length();
        
        if(m<n)
            return "";
        
        int freq[] = new int[128];
        int characters = 0;
        
        for(int i=0;i<n;i++){
            freq[t.charAt(i)]++;
            characters++;
        }
        int start =0, end = 0;
        int min_length = Integer.MAX_VALUE;
        int start_index = 0;
        
        while(end<m){
            if(freq[s.charAt(end)]>0)
                characters--;
            freq[s.charAt(end)]--;
            end++;
            while(characters==0){
                if(min_length>end-start){
                    min_length = end-start;
                    start_index = start;
                }
                freq[s.charAt(start)]++;
                if(freq[s.charAt(start)]>0){
                    characters++;
                }
                start++;
            }
        }
        return min_length == Integer.MAX_VALUE? "" : s.substring(start_index,start_index+min_length);
    }
}