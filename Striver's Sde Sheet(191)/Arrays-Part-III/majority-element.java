// https://leetcode.com/problems/majority-element/description/

class Solution {
    public int majorityElement(int[] nums) {

        /*
          Brute Force: 
             Consider all elements 
                for(0 to n)
                   count=1;
                  for(1 to n)
                    count the elements 
                  
                   if(count>n/2)
                     return nums[i]
           Tc - O(N^2)
           Sc - O(1)
 
         Mark the index which are already counted using visited array. 
         Skip the marked index. 

         Second Approach:

           using HashMap - Count the frequncy of each elements
           Atlast iterate over the map and check the frequency is > n/2

           Tc - O(n) + O(n)
           Sc - O(n)

        Optimal approach:
           Using Moore's voting algorithm. 

        */

       
        /*
        Map<Integer,Integer> hash=new HashMap<>();
        int ans=-1;

        for(int i=0;i<n;i++){
            hash.put(nums[i],hash.getOrDefault(nums[i],0)+1);
        }

        for(Map.Entry<Integer,Integer> entry:hash.entrySet()){
            if(entry.getValue() > n/2){
                ans=entry.getKey();
                break;
            }
        }

        return ans;

        */

         int n=nums.length;
         int majorityElement=nums[0];
         int count=1;

         for(int i=1;i<n;i++){
            if(nums[i]==majorityElement){
                count+=1;
            }else{
                count--;
                if(count==0){
                    majorityElement=nums[i];
                    count=1;
                }
            }
         }

         return majorityElement;

    }
}