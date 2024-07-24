// https://www.interviewbit.com/problems/repeat-and-missing-number-array/

//Input:[3 1 2 5 3] , contains 1 to n. Exactly one number is repeated twice.

// Output:[3, 4]  3-repeating number, 4- missing number

//Brute force : For every number 1 to n, iterate over the array(0 to n-1) 
// count the occurence, if(count===2) --it is the repeating number
//if(count===0) -->it is the missing number . If we found both we may break out from the loop.
//Tc is O(N^2) and the SC is O(1).

for(let i=1;i<=n;i++){
    let count=0;
    for(let index=0;index<n;index++){
        if(nums[index]===i){
            count++;
        }
    }
    if(count===2){
        repeating=i;
    }else if(count===0){
        missing=i;
    }

    if(repeating!=-1 && missing!=-1)break;
}
// ---------------------------------------------------------------------------------------

//Better (Using hash Array)
   function repeating() {
       let n=A.length;
       
        let frequency=new Array(n+1).fill(0);
        let repeating=-1;
        let missing=-1;
        
        for(let index=0;index<n;index++){
           frequency[A[index]]++;
        }
        
        for(let index=1;index<=n;index++){    
            if(frequency[index]===2){
              repeating=index;
            }else if(frequency[index]===0){
                missing=index;
            }
            
            if(repeating!=-1 && missing!=-1){
                break;
            }
            
        }  
        return [repeating,missing];


   }
        //TC is O(N + N), SC is O(N)


//Optimal Approach 1 : Using Mathematics

/*

  module.exports = { 
 //param A : array of integers
 //return a array of integers
	repeatedNumber : function(a){
          
    const n = a.length; // size of the array

    // Find Sn and S2n:
    const SN = (n * (n + 1)) / 2;
    const S2N = (n * (n + 1) * (2 * n + 1)) / 6;

    // Calculate S and S2:
    let S = 0, S2 = 0;
    for (let i = 0; i < n; i++) {
        S += a[i];
        S2 += a[i] * a[i];
    }

    //S-Sn = X-Y:
    const val1 = S - SN;

    // S2-S2n = X^2-Y^2:
    let val2 = S2 - S2N;

    //Find X+Y = (X^2-Y^2)/(X-Y):
    val2 = val2 / val1;

    //Find X and Y: X = ((X+Y)+(X-Y))/2 and Y = X-(X-Y),
    // Here, X-Y = val1 and X+Y = val2:
    let x = (val1 + val2) / 2;
    let y = x - val1;
        
    return [x, y];         
             
	}
};

*/

//Optimal Approach using XOR

  function appr3(A){
    //param A : array of integers
    //return a array of integers
       
           
           let n=A.length;
           let xor=0;
           
           for(let index=0;index<n;index++){
               xor=xor^A[index];
               xor=xor^(index+1);
           }
           
           let zero=0;
           let one=0;
           
           //Find first set bit in the xor value
            let number=(xor & ~(xor-1));
           
           for(let index=0;index<n;index++){
               
               if((A[index] & number)!=0)
               {
                   one=one^A[index];
               }else{
                   zero=zero^A[index];
               }
           }
           
           for(let i=1;i<=n;i++){
               if((i & number)!=0){
                   one=one^i;
               }else{
                   zero=zero^i;
               }
           }
           
           let count=0;
           for(let index=0;index<n;index++){
               if(A[index]===zero){
                   count++;
               }
           }
           
           if(count===2){
               return [zero,one];
           }
           
           return [one,zero];
   
 }
    
   

