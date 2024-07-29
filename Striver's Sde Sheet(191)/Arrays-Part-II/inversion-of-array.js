// https://www.naukri.com/code360/problems/count-inversions_615?count=25&search=&sort_entity=order&sort_order=ASC&page=1&leftPanelTabValue=PROBLEM

//Inversion of array
/*
 'ARR[i] > 'ARR[j]' 
 'i' < 'j'

Input:

5
2 5 1 3 4

Sample Output :

4
Explanation of Sample Output 1:
We have a total of 4 pairs which satisfy the condition of inversion. (2, 1), (5, 1), (5, 3) and (5, 4).
*/

//Brute Force:
//Consider all pairs - O(n^2)

//Optimal Approach.

function merger(start, mid, end, arr) {
  let tempArr = new Array(end - start + 1);
  let idx = 0;

  let i = start;
  let j = mid + 1;

  let count = 0;

  while (i <= mid && j <= end) {
    if (arr[i] <= arr[j]) {
      tempArr[idx] = arr[i];
      idx++;
      i++;
    } else {
      count += mid - i + 1; //This is the sweetest part to add. 
      tempArr[idx] = arr[j];
      idx++;
      j++;
    }
  }

  while (i <= mid) {
    tempArr[idx] = arr[i];
    idx++;
    i++;
  }

  while (j <= end) {
    tempArr[idx] = arr[j];
    idx++;
    j++;
  }

  idx = 0;
  for (let k = start; k <= end; k++) {
    arr[k] = tempArr[idx];
    idx++;
  }

  return count;
}

function mergeSort(start, end, arr) {
  let count = 0;
  if (start < end) {
    let mid = Math.floor((start + end) / 2);
    // console.log(mid);
    count += mergeSort(start, mid, arr);
    count += mergeSort(mid + 1, end, arr);
    count += merger(start, mid, end, arr);
  }

  return count;
}

function main() {
  /* Read your input here 
    eg: For string variables:   let str = String(readLine()); 
        For int variables: let var_name = parseInt(readLine());
        For arrays : const arr = readLine().replace(/\s+$/g, '').split(' ');
    */

  let n = parseInt(readLine());
  const arr = readLine().replace(/\s+$/g, "").split(" ");

  /*
    Call your function with the input/parameters read above
    eg: let x = example(var_name, arr);
    */
  for (let index = 0; index < n; index++) {
    arr[index] = +arr[index];
  }

  let count = mergeSort(0, n - 1, arr);

  /*
   Log your output here 
   eg: console.log(x);
   */
  console.log(count);
}
