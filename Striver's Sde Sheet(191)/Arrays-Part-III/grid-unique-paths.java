/*
  Brute Force: Consider all possible paths
  Tc : O(2^(m*n)) - Exponential time complexity
  Sc : O(m*n)

  class Solution {
    public int findPaths(int row,int col,int m,int n){
       if(row==m-1 && col==n-1){
        return 1;
       }
       if(row>=m || col>=n){
        return 0;
       }

       int count=0;
       count+=findPaths(row+1,col,m,n);
       count+=findPaths(row,col+1,m,n);
       return count;
    }
    public int uniquePaths(int m, int n) {
        int ans=findPaths(0,0,m,n);
        return ans;
    }
}
 */

 /*Optimal Approach: Using Memoization
   Tc : O(m*n)
   Sc : O(m*n)
  */

  class Solution {
    public int findPaths(int row,int col,int[][] paths){
       if(row==0 && col==0){
        return 1;
       }
       if(row<0 || col<0){
        return 0;
       }

       if(paths[row][col]!=-1)
       {
         return paths[row][col];
       }

       int count=0;
       count+=findPaths(row-1,col,paths);
       count+=findPaths(row,col-1,paths);
       
       return paths[row][col]=count;
    }
    public int uniquePaths(int m, int n) {
        int[][] paths=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(paths[i],-1);
        }
        
        int ans=findPaths(m-1,n-1,paths);
        return ans;
    }
}