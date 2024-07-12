/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function (prices) {
  let size = prices.length;
  let profit = 0; //We need maximum profit
  let buyingPrice = Infinity; //It should be minimum

  for (let index = 0; index < prices.length; index++) {
    buyingPrice = Math.min(buyingPrice, prices[index]);
    profit = Math.max(profit, prices[index] - buyingPrice);
  }

  return profit;

  //Time complexity is O(n).

  /*  for(let outerIndex=0;outerIndex<prices.length;outerIndex++){
       for(let innerIndex=outerIndex+1;innerIndex<prices.length;innerIndex++){
          profit=Math.max(profit,prices[innerIndex]-prices[outerIndex]);
       }
    }

    return profit;

    //Tc is O(n^2), TLE for large datasets. */
};
