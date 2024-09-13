import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int ans = 0;
        int pos = 1; 
        int i = 0; 
        int range = 2 * w + 1; 

        while (pos <= n) {
            if (i < stations.length && stations[i] - w <= pos) {
                pos = stations[i] + w + 1;
                ++i;
            } else {
                pos += range;
                ++ans;
            }
        }

        return ans;
    }
}