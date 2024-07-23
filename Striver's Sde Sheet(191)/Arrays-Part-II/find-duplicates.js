// https://leetcode.com/problems/find-the-duplicate-number/description/

// Input: nums = [1,3,4,2,2]
// Output: 2


// ---------------------------------------------------------------------------
//BF - Consider every number and check for its duplicates.
//TC will be - O(n^2) Sc- O(1), Will not modify the array.
// ----------------------------------------------------------------------

//Better

/**
 * @param {number[]} nums
 * @return {number}
 */
var findDuplicate = function(nums) {
    nums.sort((a,b)=>{
        return a-b;
    });

    let ans=-1;

    for(let index=1;index<nums.length;index++){
       if(nums[index]===nums[index-1]){
        ans=nums[index];
        break;
       }
    }

    return ans;
};

//Tc is O(N log N), Sc is O(1) - Modifies the array, Not recommended

// ----------------------------------------------------------------------------------

//Best Solution

/**
 * @param {number[]} nums
 * @return {number}
 */
var findDuplicate = function(nums) {
    // int n=nums.length;
    let result=-1;

    for(let index=0;index<nums.length;index++){
        let idx=Math.abs(nums[index]);
        if(nums[idx]<0){
           result=idx;
           break;
        }
        nums[idx]=-nums[idx];
    }
    return result;

};
// Tc is O(N), SC is O(1) -- This also modifies the array right?

// -----------------------------------------------------------------------

// Using slow and fast pointer

var findDuplicate = function(nums) {

    //  Using slow and fast pointer

    let slow=nums[0];
    let fast=nums[0];

    do{
        slow=nums[slow];
        fast=nums[nums[fast]];
    }while(slow!=fast);

    fast=nums[0];

    while(slow!=fast){
        slow=nums[slow];
        fast=nums[fast];
    }
    return slow;
};

// Tc is O(n), Sc is O(1)

/*
  speed of fast = 2 * speed of slow

  See linked list 2 lecture notes from scaler. for proof. 
*/

// -----------------------------------------------------------------------


/* Further approaches 


// Use swapping the array elements tehnique - Also modifies the original array(Not recommended)
/*
Tc - O(2N)+O(N), Sc-O(1)

var findDuplicate = function(nums) {

    let n=nums.length;
    let duplicate=-1;
    
    //Put the elements in their correct position. ie. nums[index]=index+1
    for(let index=0;index<n;index++){
        //Swapping the elements until the nums[index]!=index+1
        while((nums[index]-1)!=index){
            if(nums[nums[index]-1]===nums[index]){
                break;
            }
            let temp=nums[nums[index]-1];
            nums[nums[index]-1]=nums[index];
            nums[index]=temp;
        }
    }
    
    //Every elements will be in its correct position except one element. 
    //That is the required duplicate. 
    for(let index=0;index<n;index++){
        if(nums[index]-1!=index){
          duplicate=nums[index];
          break;
        }
    }

    return duplicate;

    
};

*/

/*

Use Frequency array(n+1)
Iterate over the given array  
if(freq[nums[i]]===0){
  freq[nums[i]]++;
}else{
  return nums[i];
}

Will not modify the original array.

Tc - O(n) , Sc is O(n)
*/

