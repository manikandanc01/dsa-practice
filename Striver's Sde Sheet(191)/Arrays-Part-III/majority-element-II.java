//https://leetcode.com/problems/majority-element-ii/description/

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        /*
         Brute force is using two loops 
         For every element count its freequency of occurence
         If count is > n/3 than add it to ans list 
         return ans. 

         Tc will be O(n^2), SC -- O(1)

         ----------------------------
         2. Better Approach(Using HashMap)
          one pass also possible see striver's page.

          int n=nums.length;
          HashMap<Integer,Integer> hash=new HashMap<>();

         for(int i=0;i<n;i++){
            int value=hash.getOrDefault(nums[i],0);
            hash.put(nums[i],value+1);
        }

        List<Integer> ans=new ArrayList<>();

        for(Map.Entry<Integer,Integer> entry:hash.entrySet()){
            if(entry.getValue()> (n/3)){
                ans.add(entry.getKey());
            }
        }

        return ans;

        Tc -- O(Nlogn) + O(N) - For inserting into hashmap takes logn time
        Sc -- O(N)
          
        */

        //Optimal Approach: Moore's Voting Algorithm: 
        //Cancellation logic
        //At max 2 elements will be there in the answer. 
        // n=8, 8/3=2, >2 --> 3+3+3=9, 9>8, so at max 2 elements

       int n=nums.length;
       int count1=0;
       int count2=0;

       int majority1=-1;
       int majority2=-1;

       List<Integer> ans=new ArrayList<>();

       for(int i=0;i<n;i++){
        if(count1==0 && nums[i]!=majority2){
            count1=1;
            majority1=nums[i];
        }else if(count2==0 && nums[i]!=majority1){
            count2=1;
            majority2=nums[i];
        }else if(nums[i]==majority1){
            count1++;
        }else if(nums[i]==majority2){
            count2++;
        }
        else{
            count1--;
            count2--;
        }
       }

       int cnt1=0;
       int cnt2=0;

       for(int i=0;i<n;i++){
        if(nums[i]==majority1){
            cnt1++;
        }else if(nums[i]==majority2){
            cnt2++;
        }
       }

       if(cnt1 > (n/3)){
         ans.add(majority1);
       }

       if(cnt2 > (n/3)){
        ans.add(majority2);
       }
  
      return ans; 
        
    }
}