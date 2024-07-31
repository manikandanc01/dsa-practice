//https://leetcode.com/problems/find-the-count-of-numbers-which-are-not-special/description/

/**
 * @param {number} l
 * @param {number} r
 * @return {number}
 */

// function countDivisors(num){
//     let divisorCount=0;
//     for(let divisor=1;divisor<num;divisor++){
//         if(num%divisor===0){
//             divisorCount++;
//         }
//         if(divisorCount>2){
//             break;
//         }
//     }
//     return divisorCount;
// }

function countFactors(num){
    
    if(num===1){
        return 0;
    }
    
    let factors=1;
    
    for(let i=2;i*i<=num;i++){
        
        if(num%i===0){
             if(num/i===i){
                 factors+=1;
             }else{
                 factors+=2;
             }
        }    
    }
    
    return factors;
    
}
var nonSpecialCount = function(l, r) {
    let count=0;
    let start=Math.ceil(l**(1/2));
    let end=Math.floor(r**(1/2));
    
    // console.log(start,end);
    
    
    let primeCount=0;
    for(let i=start;i<=end;i++){
        let factors=countFactors(i);
        if(factors===1){
            primeCount++;
        }        
    }
    
    count=(r-l+1)-primeCount;
    
    // console.log(start,end);
    
    
    
    
//     for(let dividend=l;dividend<=r;dividend++){
//         if(countDivisors(dividend)!==2){
//             count++;
//         }
//     }
    
    return count;
};