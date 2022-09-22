class Solution {
    public String reverseWords(String s) {
        
        String[] ar = s.split(" ");
        String ans = "";
        StringBuilder str = new StringBuilder();
        for(int i=0; i<ar.length; i++){
            str.append(ar[i]);
            if(i==ar.length-1)
                ans+=str.reverse().toString();
            else
                ans += str.reverse().toString()+" ";  
            str.setLength(0);
        }
        return ans;
    }
}