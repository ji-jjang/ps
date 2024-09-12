/*
아이디어:
시간복잡도: O(n) 
자료구조: 
*/
import java.util.*;

class Solution {
    public int solution(String s) {
        
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (!stk.isEmpty() && stk.peek() == c) {
                stk.pop();
            } else {
                stk.push(c);
            }
        }
        return stk.isEmpty() ? 1 : 0;
    }
}