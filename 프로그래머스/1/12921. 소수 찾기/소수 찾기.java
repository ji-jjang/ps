class Solution {
    public int solution(int n) {
        int ans = 0;
        for (int i = 2; i <= n; ++i) {
            if (isPrime(i)) ++ans;
        }
        return ans;
    }
    
    boolean isPrime(int num) {
        if (num == 2) return true;
        for (int i = 2; i <= num / i; ++i) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}