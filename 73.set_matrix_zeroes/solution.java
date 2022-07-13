/**
 Runtime: 1 ms, faster than 96.99% of Java online submissions for Set Matrix Zeroes.
 Memory Usage: 54.7 MB, less than 14.09% of Java online submissions for Set Matrix Zeroes.
 */
class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix[0].length;
        int m = matrix.length;
        boolean rowHasZero = false;
        boolean columnHasZero = false;
        
        // First check if 1st row & 1st column has 0
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                columnHasZero = true;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                rowHasZero = true;
            }
        }
        
        // Mark all rows and columns that has 0
        for (int i = 1; i < m ; i++) {
            for (int j = 1; j < n ; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        // Update matrix with 0 for marked rows and columns 
        // except row 1 and column 1
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        if (rowHasZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        
        if (columnHasZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}