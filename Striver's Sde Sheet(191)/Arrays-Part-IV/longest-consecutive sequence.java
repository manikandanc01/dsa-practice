class Solution {
    public int longestConsecutive(int[] nums) {
        /*
          Brute force is
            -- for every element, check for its consecutive sequence x+1,x+2, x+3 present or not
            -- Tc will be O(n^2), Sc is O(1)
          Better solution is 
            --Sort the array
            --Check for longest consecutive sequence by checking its 
              adjacent elements
            --Tc will be O(nlogn)
            --Sc is O(1)
        */
        // Optimal approach - Using Hashset. 
        int n=nums.length;
        HashSet<Integer> hash=new HashSet<>();

        for(int num:nums){
            hash.add(num);
        }
        
        int result=0;
        for(int i=0;i<n;i++){
            if(!hash.contains(nums[i]+1)){
                int count=0;
                int currValue=nums[i];

                while(hash.contains(currValue)){
                    count++;
                    currValue-=1;
                }
                result=Math.max(result,count);
            }
        }

        return result;
    }

    //Tc is O(n) + O(2*N) -- At max every element is visisted twice in the second loop
    // We are not traversing for every element, if the current element is the last element of 
    // the sequence then only we are traversing the set to check x-1,x-2, x-3...and so on
    // Sc is O(N)-- For hashset
}