import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                s.add(numbers[i] + numbers[j]);
            }
        }
        return s.stream().sorted().mapToInt(Integer::intValue).toArray();   
    }
}