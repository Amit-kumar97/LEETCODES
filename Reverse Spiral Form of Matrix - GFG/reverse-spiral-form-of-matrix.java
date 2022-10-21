//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String[] input = new String[2]; 
            input = read.readLine().split(" "); 
            int R = Integer.parseInt(input[0]); 
            int C = Integer.parseInt(input[1]); 
            String s1[] = read.readLine().trim().split("\\s+");
            int a[][] = new int[R][C];
            for(int i = 0;i < R*C;i++)
                a[i/C][i%C] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int[] ans = ob.reverseSpiral(R,C,a);
            for(int i = 0; i < ans.length; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    public int[] reverseSpiral(int R, int C, int[][] a)
    {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        solve(a, 0, 0, R, C, list);
        Collections.reverse(list);
        int[] res = new int[list.size()];
        for (int i=0; i<res.length; i++){
            res[i] = list.get(i).intValue();
        }
        return res;
    }
    static void solve(int arr[][], int i, int j, int m, int n, List<Integer> list)
    {
        if(i>=m || j>=n) {
            return;
        }
        for(int p = i; p < n; p++) {
            list.add(arr[i][p]);
        }
        for(int p = i + 1; p < m; p++) {
            list.add(arr[p][n-1]);
        }
        if((m-1)!=i) {
            for (int p=n-2; p>=j; p--) {
                list.add(arr[m-1][p]);
            }
        }
        if((n-1)!=j) {
            for(int p=m-2; p>i; p--) {
                list.add(arr[p][j]);
            }
        }
        solve(arr, i+1, j+1, m-1, n-1, list);
    }
}