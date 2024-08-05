class Solution {
    public int[] twoSum(int[] nums, int target) {
        /*
          Brute force consider all pair sums. 
          Tc is O(n^2)
          Sc is O(1)
        */

        HashMap<Integer,Integer> hash=new HashMap<>();

        int n=nums.length;
        int[] result=new int[2];

        for(int i=0;i<n;i++){
            Integer value=target-nums[i];
            if(hash.containsKey(value)){
                result[0]=hash.get(value);
                result[1]=i;
                break;
            }
            hash.put(nums[i],i);
        }

        return result;
    }
}