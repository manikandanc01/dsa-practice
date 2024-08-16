 
// Brute force is Consider all Subarrays, find xor of each subarrays, if xor is equal to B, icrement the count and finally return count
// Tc is O(n^3), Sc is O(1)

// Better Approach: Using carry forward or prefix xor method, 
// Tc is O(n^2), Sc is O(1)

// Optimal Approach is using HashMap.
// Take a prefix xor 
// Lets say xr is the prefix xor of all elements from 0 to ith index. [0....i.....n]
// if a subarray with xor B is present in the range (0 to ith index), 
// xr = x ^ k 
// xr (0 to ith index xor)
// k --> is a xor of required subarray
// x --> is a xor of remaining portion

// XOR with k on both sides
// xr ^ k = x ^ k ^ k;
// xr ^ k = x

// Tc is O(n), Sc is  O(n)

public class Solution {
    public int solve(int[] A, int B) {
        
        int n=A.length;
        int count=0;
        
        // for(int i=0;i<n;i++){
        //     int xor=0;
        //     for(int j=i;j<n;j++){
        //         xor=xor^A[j];
        //         if(xor==B){
        //             count++;
        //         }
        //     }
        // }
        // //Tc will be O(n^2), Sc is O(1)
        
        Map<Integer,Integer> hash=new HashMap<>();
        hash.put(0,1);
        int xr=0;
        
        for(int i=0;i<n;i++){
            xr=xr^A[i];
            
            if(hash.containsKey(xr^B)){
                count+=hash.get(xr^B);
            }
            hash.put(xr,hash.getOrDefault(xr,0)+1);
        }
        
        return count;
    }
}
