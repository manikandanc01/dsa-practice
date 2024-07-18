// https://takeuforward.org/interviews/strivers-sde-sheet-top-coding-interview-problems


// Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
// Example 1:

// Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
// Output: [[1,6],[8,10],[15,18]]
// Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
// Example 2:

// Input: intervals = [[1,4],[4,5]]
// Output: [[1,5]]
// Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 

// Constraints:

// 1 <= intervals.length <= 104
// intervals[i].length == 2
// 0 <= starti <= endi <= 104

// Brute Force is O(N log n) + O(2N) -- Visit website 

// Optimization -- O(N log n) + O(N)
/**
 * @param {number[][]} intervals
 * @return {number[][]}
 */
var merge = function(intervals) {
    let n=intervals.length;
    //Brute force is O(Nlogn + O(2N)--->See strivers sheet)

    //Optimization is O(nlogn + n)
    intervals.sort((a,b)=>{
        if(a[0]<b[0]){
            return -1;
        }else if(a[0]>b[0]){
            return 1;
        }
        return a[1]-b[1];        
    });
    
    let result=[];
    let start=intervals[0][0];
    let end=intervals[0][1];
    // console.log(intervals);
    for(let i=1;i<n;i++){
        //Means overlapping
        if(intervals[i][0] <= end){
            end=Math.max(end,intervals[i][1]);
        }else{
            result.push([start,end]);
            start=intervals[i][0];
            end=intervals[i][1];
        }
        // console.log(start+" "+end);
    }
    
    result.push([start,end]);
    return result;
    
};