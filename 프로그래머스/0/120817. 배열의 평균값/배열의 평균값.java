class Solution {
    public double solution(int[] numbers) {
        
        double ans = 0;
        for (var e : numbers)
            ans += e;
        return (double) 1.0 * ans / numbers.length;
    }
}