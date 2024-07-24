import java.util.*;

class Solution {
    public String solution(int n) {
        
        String base = "124";
        
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(base.charAt(--n % 3));
            n /= 3;
        }
   
        return sb.reverse().toString();
    }
}