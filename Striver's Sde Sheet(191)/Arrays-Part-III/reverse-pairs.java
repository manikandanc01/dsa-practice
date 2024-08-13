// Brute force is consider all pairs
// Check nums[i]>2*nums[j], increment the count and return 
// Tc is O(n^2), and Sc is O(1)



// Optimal Approach
class Solution {

    void merger(int start,int mid,int end,int[] nums){
        int[] temp=new int[end-start+1];
        int i=start;
        int j=mid+1;

        int idx=0;
        while(i<=mid && j<=end){

           if(nums[i]<nums[j]){
            temp[idx++]=nums[i++];
           }else{
            temp[idx++]=nums[j++];
           }
        }

        while(i<=mid){
            temp[idx++]=nums[i++];
        }

        while(j<=end){
            temp[idx++]=nums[j++];
        }
        
        idx=0;
        for(int k=start;k<=end;k++){
            nums[k]=temp[idx++];
        }
    }
    int countPairs(int start,int mid,int end,int[] nums){
        int count=0;
        int j=mid+1;

        for(int i=start;i<=mid;i++){    
            while(j<=end && (long)nums[i]>2l*(long)nums[j]){
                 j++;
            }
            count+=j-(mid+1);
        }
        return count;
    }

    int mergeSort(int start,int end,int[] nums){
        int count=0;
        if(start<end){
            int mid=(start+end)/2;
            count+=mergeSort(start,mid,nums);
            count+=mergeSort(mid+1,end,nums);
            count+=countPairs(start,mid,end,nums);
            merger(start,mid,end,nums);
        }
        return count;
    }
    public int reversePairs(int[] nums) {

        int n=nums.length;
        return mergeSort(0,n-1,nums);        
    }
}

// Tc is 