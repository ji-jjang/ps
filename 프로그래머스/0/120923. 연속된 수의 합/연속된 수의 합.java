import java.util.stream.*;

class Solution {
    public int[] solution(int num, int total) {
        
        int sum = 0;
        for (int i = 0; i < num; ++i) 
            sum += i;
        int st = (total - sum) / num;
        
        return IntStream.range(st, st + num).toArray();
    }
}