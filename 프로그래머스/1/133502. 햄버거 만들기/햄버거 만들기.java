import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        List<Integer> stuffs = new LinkedList<>();
        int ans = 0;
        for (var e : ingredient) {
            stuffs.add(e);
            if (stuffs.size() >= 4) {
                if (stuffs.get(stuffs.size() - 1 ) == 1
                    && stuffs.get(stuffs.size() - 2) == 3 
                    && stuffs.get(stuffs.size() - 3) == 2
                    && stuffs.get(stuffs.size() - 4) == 1) {
                    
                    ++ans;
                    stuffs.remove(stuffs.size() - 1);
                    stuffs.remove(stuffs.size() - 1);
                    stuffs.remove(stuffs.size() - 1);
                    stuffs.remove(stuffs.size() - 1);
                }
            }
        }
        return ans;
    }
}