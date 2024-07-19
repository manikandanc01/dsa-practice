// https://leetcode.com/problems/merge-sorted-array/

/*Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.

*/

// Brute Force Approach

/**
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */
var merge = function(nums1, m, nums2, n) {

    let sortedArray=[m+n];

    let indexOne=0;
    let indexTwo=0;
    
    let index=0;
    while(indexOne<m && indexTwo<n){
        if(nums1[indexOne]<=nums2[indexTwo]){
            sortedArray[index++]=nums1[indexOne++];
        }else{
            sortedArray[index++]=nums2[indexTwo++];
        }
    }

    while(indexOne<m){
        sortedArray[index++]=nums1[indexOne++];
    }

    while(indexTwo<n){
        sortedArray[index++]=nums2[indexTwo++];
    }
    
    for(let idx=0;idx<sortedArray.length;idx++){
        nums1[idx]=sortedArray[idx];
    }
    
};


// Tc is O(m+n)+O(m)+O(n)+O(m+n)
// Sc is O(m+n)

//Optimized Approach

/**
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */
var merge = function(nums1, m, nums2, n) {

    //Edge case
    if(m==0){
        let idx=0;
        for(let index=0;index<n;index++){
          nums1[idx++]=nums2[index];
        }
    }

    let index=m+n-1;
    let indexOne=m-1;
    let indexTwo=n-1;

    while(indexOne>=0 && indexTwo>=0){
        if(nums1[indexOne]>nums2[indexTwo]){
            nums1[index--]=nums1[indexOne--];
        }else{
            nums1[index--]=nums2[indexTwo--];
        }
    }

    while(indexTwo>=0){
        nums1[index--]=nums2[indexTwo--];
    }
    
};

//Tc is O(m+n)
//Sc is O(1)

