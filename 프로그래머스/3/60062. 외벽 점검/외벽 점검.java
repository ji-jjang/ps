import java.util.*;

public class Solution {
    public int solution(int n, int[] weak, int[] dist) {
        List<Integer> weaks = new ArrayList<>();
        
        for (int i = 0; i < weak.length; ++i) weaks.add(weak[i]);
        
        for (int i = 0; i < weak.length - 1; ++i) weaks.add(n + weak[i]);

        for (var d : weaks) System.out.println(d);
        
        return 0;
    }
}