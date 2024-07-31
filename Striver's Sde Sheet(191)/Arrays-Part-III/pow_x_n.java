/*
 Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000
Example 2:

Input: x = 2.10000, n = 3
Output: 9.26100
Example 3:

Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25

BF approach is : double ans=1.0, 
    for(i=1 to n)
      ans=ans*x;

TC will be O(n)
SC will be O(1)

Below is the Optimal approach. 

To avoid overflow long is used. 
Integer range -2147..48 to 2147...47

if n is -2147....48

when we change into positive number, it will overflow. 

To avoid that long variable is used. 


Algorithm:

2^10 = (2*2)^5 = 4^5
4^5 = 4 * 4^4
4^4 = (4*4)^2 = 16^2
16^2= (16 * 16)^1 = 256^1
256^1 = 256 * 256^0
256^0 = 1

In general 

if(n is even)
   x=x*x
   n=n/2
else
  ans=ans*x
  n=n-1

 */

class Solution {
    public double myPow(double x, int n) {

        double ans=1.0;
        long nn=n;

        if(nn<0){
            nn=-(nn);
        }

        while(nn>0){
            if(nn%2==0){
                x=x*x;
                nn/=2;
            }else{
                ans=ans*x;
                nn=nn-1;
            }
        }
        if(n<0){
            ans=1.0/ans;
        }
        return ans;
    }
}