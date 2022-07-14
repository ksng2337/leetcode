/**
 Runtime: 89 ms, faster than 97.08% of Java online submissions for Word Search.
 Memory Usage: 42.4 MB, less than 41.04% of Java online submissions for Word Search.
 */
class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board[0].length;
        int n = board.length;
        
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (board[y][x] == word.charAt(0)) {
                    if (word.length() == 1) {
                        return true;
                    } else {
                        // start searching
                        boolean[][] visited = new boolean[n][m];
                        visited[y][x] = true;
                        if (findMatch(board, visited, x, y, word, 1)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    
    private boolean findMatch(char[][] board, boolean[][] visited, 
                              int x, int y, String word, int index) {
        if (index == word.length()) {
            return true;
        } else {
            boolean result = false;
            // check next char in 4 directions
            // up
            if (y > 0 && !visited[y - 1][x] && board[y - 1][x] == word.charAt(index)) {
                visited[y - 1][x] = true;
                result = findMatch(board, visited, x, y - 1, word, index + 1);
                visited[y - 1][x] = false;
            }
            // right
            if (!result && x < board[0].length - 1 && !visited[y][x + 1] && 
                board[y][x + 1] == word.charAt(index)) {
                visited[y][x + 1] = true;
                result =  findMatch(board, visited, x + 1, y, word, index + 1);
                visited[y][x + 1] = false;
            }
            // down
            if (!result && y < board.length - 1 && !visited[y + 1][x] && 
                board[y + 1][x] == word.charAt(index)) {
                visited[y + 1][x] = true;
                result = findMatch(board, visited, x, y + 1, word, index + 1);
                visited[y + 1][x] = false;
            }
            // left
            if (!result && x > 0 && !visited[y][x - 1] && board[y][x - 1] == word.charAt(index)) {
                visited[y][x - 1] = true;
                result = findMatch(board, visited, x - 1, y, word, index + 1);
                visited[y][x - 1] = false;
            }
            return result;
        }
    }
}