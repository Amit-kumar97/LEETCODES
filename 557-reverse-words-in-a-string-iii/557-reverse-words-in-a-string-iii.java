class Solution {
    public String reverseWords(String s) {
        
        String[] ar = s.split(" ");
        String ans = "";
        for(int i=0; i<ar.length; i++)
        {
            StringBuilder str = new StringBuilder();
            str.append(ar[i]);
            str.reverse();
            if(i==ar.length-1)
                ans+=str.toString();
            else
                ans += str.toString()+" ";     
        }
        return ans;
    }
}