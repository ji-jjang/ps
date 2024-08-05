
class Solution {
    public int[] solution(long begin, long end) {
        
        int st = (int) begin;
        int en = (int) end;
        int[] ans = new int[en - st + 1];
        
        for (int i = st; i <= en; ++i) {
            ans[i - st] = getPrimeOrBiggestDivisor(i);
        }
        return ans;
    }
    
    int getPrimeOrBiggestDivisor(int num) {
        if (num < 2)
            return 0;
        int biggestDivisor = 1;
        for (int i = 2; i <= num / i; ++i) {
            if (num % i == 0) {
                if (num / i <= 10_000_000) return num / i;
                biggestDivisor = i;
            } 
        }
        return biggestDivisor;
    }
}