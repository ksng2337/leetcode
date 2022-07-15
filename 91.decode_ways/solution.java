/** 
 Runtime: 1 ms, faster than 98.69% of Java online submissions for Decode Ways.
 Memory Usage: 40.5 MB, less than 95.90% of Java online submissions for Decode Ways.
 */
class Solution {
    public int numDecodings(String s) {
        int result = 0;
        int[] fib = new int[53];
        // ans must fit 32-bit int, so calculate fib list first 
        fib[0] = 1;
        fib[1] = 1;
        for (int i = 2; i < fib.length; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        
        if (s.charAt(0) != '0') {
            result = 1;
            if (s.length() > 1) {
                int index = 0;
                int gpCount = 0;
                while (index < s.length() && result > 0) {
                    if (s.charAt(index) == '0') {
                        // not 10 or 20, so is invalid
                        if (index > 0 && s.charAt(index - 1) != '1' && s.charAt(index - 1) != '2') {
                            result = 0;
                        } else {
                            // 0 must consume previous number, so count - 1
                            gpCount--;
                            result *= fib[gpCount];
                            gpCount = 0;
                        }

                    } else {
                        if (s.charAt(index) > '2') {
                            // check if can separate last 2 digit into 2 ways
                            if (index > 0 && (s.charAt(index - 1) == '1' ||
                                    (s.charAt(index - 1) == '2' && s.charAt(index) < '7'))) {
                                gpCount++;
                            } 
                            
                            result *= fib[gpCount];
                            gpCount = 0;
                            
                        } else {
                            gpCount++;
                        }
                    }
                    index++;
                }
                
                result *= fib[gpCount];
            }
        }
        return result;
    }
}
