/*
https://leetcode.com/problems/search-a-2d-matrix/description/

Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true

Bf: Linear search 
    Tc - O(n*m)
    Sc - O(1)

Better Approach:
   Every row is sorted 
   And Next row's first element is greater than the current row's last element

   So for every row, check our target lies in the range of first and last element
   if yes do binary search and return the answer found or not.

   else skip the row and move to next row.
   
   Tc - O(n + logm) -- We are doing binary search only once. not n times 
   Sc - O(1)

Optimal Solution:
  When we flatten the 2d array into 1d array the entire array will be sorted. 
  But we are not going to literally do that, just going to do imaginarily.

  And do binary search. 

  Tc will O(log (m*n))
  Sc will be O(1)
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int m=matrix.length;
        int n=matrix[0].length;

        int left=0;
        int right=(m*n)-1;

        // console.log(right);

        while(left<=right){
          int mid=(left+right)/2;

          int row=mid/n;
          int col=mid%n;

          if(matrix[row][col]==target){
            return true;
          }

          if(matrix[row][col]>target){
            right=mid-1;
          }
          else{
            left=mid+1;
          }
        }

       return false;  
    }
}