// https://leetcode.com/problems/find-if-digit-game-can-be-won/description/

/**
 * @param {number[]} nums
 * @return {boolean}
 */
var canAliceWin = function(nums) {
   
    let oneDigitSum=0;
    let twoDigitSum=0;
    
    for(let index=0;index<nums.length;index++){
        if(nums[index]<10){
            oneDigitSum+=nums[index];
        }else{
            twoDigitSum+=nums[index];
        }
    }
    
    if(oneDigitSum===twoDigitSum){
        return false;
    }
    
    return true;
    
};