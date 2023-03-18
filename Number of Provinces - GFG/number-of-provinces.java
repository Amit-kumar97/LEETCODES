//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        // converting adj matrix to list
        ArrayList<ArrayList<Integer>> adjLs = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<V; i++){
            adjLs.add(new ArrayList<Integer>());
        }
        
        for(int i=0; i<V; i++){
            for(int j=0; j<V; j++){
                if(adj.get(i).get(j)==1 && i!=j){
                    adjLs.get(i).add(j);
                    adjLs.get(j).add(i);
                }
            }
        }
        
        int c = 0;
        boolean[] vis = new boolean[V+1];
        
        for(int i=0; i<V; i++){
            if(vis[i]==false){
                c++;
                dfs(i, vis, adjLs);
            }
        }
        return c;
    }
    static void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adjLs){
        vis[node] = true;
        // ans.add(node);
        
        for(Integer i:adjLs.get(node)){
            if(vis[i]!=true)
                dfs(i, vis, adjLs);
        }
    }
};