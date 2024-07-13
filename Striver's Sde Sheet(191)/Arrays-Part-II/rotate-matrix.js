/**
 * @param {number[][]} matrix
 * @return {void} Do not return anything, modify matrix in-place instead.
 */
//Brute Force Approach
var rotate = function (matrix) {
  let n = matrix.length;
  let tempMatrix = [];
  for (let row = 0; row < n; row++) {
    tempMatrix.push(new Array(n).fill(0));
  }

  let col = 0;
  for (let r = n - 1; r >= 0; r--) {
    let row = 0;
    for (let c = 0; c < n; c++) {
      tempMatrix[row++][col] = matrix[r][c];
    }
    col++;
  }

  for (let row = 0; row < n; row++) {
    for (let col = 0; col < n; col++) {
      matrix[row][col] = tempMatrix[row][col];
    }
  }
};

//TC is O(n^2 + n^2)
//SC is O(nxn)


//Optimized Approach

/**
 * @param {number[][]} matrix
 * @return {void} Do not return anything, modify matrix in-place instead.
 */
var rotate = function(matrix) {
    //We need to do it in-place
    //Transpose the matrix and reverse each row

    for(let row=0;row<matrix.length;row++){
        for(let col=row;col<matrix[0].length;col++){
            let temp=matrix[row][col];
            matrix[row][col]=matrix[col][row];
            matrix[col][row]=temp;
        }
    }
   
    for(let index=0;index<matrix.length;index++){
        matrix[index].reverse();
    }

    //Tc ==>O(n^2 + n^2)
    //SC ==>O(1)

};