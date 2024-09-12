/*
아이디어: 정렬
시간복잡도: O(n * logn) 
자료구조: 
*/
import java.util.Arrays;

class Solution {
    public int solution(int[][] routes) {
 
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));

        int ans = 0;
        int last = -100_000;
        for (var route : routes) {
            if (last < route[0]) {
                ++ans;
                last = route[1];
            }
        }
        return ans;
    }
}