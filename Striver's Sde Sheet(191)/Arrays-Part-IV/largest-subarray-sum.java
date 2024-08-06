//{ Driver Code Starts
import java.util.*;

class MaxLenZeroSumSub
{

    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
    }
}
// } Driver Code Ends


class GfG
{
    int maxLen(int arr[], int n)
    {
        // Your code here
        
        //Brute force - Consider all subarrays 
        // Take sum and check for 0 and find the longest subarray
        //Tc - O(n3) --> O(n2) (By using carry forward method)
        
        //Optimal approach - Using HashMap
        
        HashMap<Integer,Integer> hash=new HashMap<>();
        
        int sum=0;
        int ans=0;
        
        hash.put(0,-1);
        
        for(int i=0;i<n;i++){
            sum+=arr[i];
            
            if(hash.containsKey(sum)){
                ans=Math.max(ans,i-hash.get(sum));
            }
            
            if(!hash.containsKey(sum)){
                hash.put(sum,i);
            }
        }
        
        return ans;
    }
}

//Tc - O(n) 
//Sc - O(n)