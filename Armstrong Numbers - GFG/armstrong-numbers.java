//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.armstrongNumber(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    static String armstrongNumber(int n){
        // code here
        int temp = n;
        int calculatedNumber = 0;
        
        while(n!=0){
            int rem = n%10;
            calculatedNumber += rem*rem*rem;
            
            n = n/10;
        }
        if(temp==calculatedNumber)
            return "Yes";
        else
            return "No";
    }
}