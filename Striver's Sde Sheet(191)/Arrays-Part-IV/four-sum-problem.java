//Brute Force is using Four loops
// Tc is O(n^4)
// Sc is O(n)-set is needed here also

//Better Approach - Using hashMap in the two sum - It will takes some more extra space

//Optimal Approach
// Tc is O(n logn) + O(n^3)
// Sc is O(n)
class Solution {
    Set<List<Integer>> store;
    public void twoSum(int[] nums,int startIndex,long target,int n,int a,int b){
        int c=startIndex;
        int d=n-1;

        while(c<d){
            long sum=(long)nums[c]+(long)nums[d];
            if(sum==target){
               store.add(new ArrayList<>(List.of(nums[a],nums[b],nums[c],nums[d])));
               c++;
               d--;
            }
            else if(sum < target){
                c++;
            }else{
                d--;
            }
        }
    }
    public void threeSum(int[] nums,int startIndex,long target,int n,int a){
        for(int b=startIndex;b<n;b++){
            long twoSumTarget=target-(long)nums[b];
            twoSum(nums,b+1,twoSumTarget,n,a,b);
        }
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n=nums.length;
        Arrays.sort(nums);
        store=new HashSet<>();
        // List<List<Integer>> result=new ArrayList<>();
        List<List<Integer>> result;

        
        for(int a=0;a<n;a++){
            long threeSumTarget=(long)target-(long)nums[a];
            threeSum(nums,a+1,threeSumTarget,n,a);
        }
        // return result;  

        // for(List<Integer> arr:store){
        //     result.add(arr);
        // } 
        result=new ArrayList<>(store);
        return result;
    }
}

// We can also get rid of using HashSet. By using simple technique see the strivers page
