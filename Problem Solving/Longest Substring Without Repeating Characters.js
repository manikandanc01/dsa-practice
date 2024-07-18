// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

/*Given a string s, find the length of the longest 
substring
 without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.*/


//Brute Force is considered all substrings -- TC will be O(N^3)
//Better solution O(N^2)


// Best solution in O(N) -- Sliding Window + HashSet, SC-->O(N) for hashset

/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {

    let n=s.length;
    let hashset=new Set();

    let i=0;
    let j=0;
    let result=0;

    while(j<n){
       while(j<n && !hashset.has(s[j])){
           hashset.add(s[j]);
           j++;
       }
       result=Math.max(result,j-i);
    //    console.log(result);
       hashset.delete(s[i]);
       i++;
    }

    return result;
    
};