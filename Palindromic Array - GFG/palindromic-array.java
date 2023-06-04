//{ Driver Code Starts
import java.util.*;
class PalindromicArray{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0)
		{
			int n = sc.nextInt();
			int[] a = new int[n];
			for(int i = 0 ;i < n; i++)
				a[i]=sc.nextInt();
			GfG g = new GfG();
			System.out.println(g.palinArray(a , n));
		}
	}
}
// } Driver Code Ends


/*Complete the Function below*/
class GfG
{
	public static int palinArray(int[] a, int n)
	{
	    int i=0;
	    while(i<n){
	        if(!palindromeNumber(a[i])){
	            return 0;
	        }
	        i++;
	    }
	    return 1;
	}
	static boolean palindromeNumber(int a){
	    int reverse = 0;
        int temp = a;
        while (temp != 0) {
            reverse = (reverse*10) + (temp%10);
            temp = temp / 10;
        }
        return (reverse == a);
	}
}