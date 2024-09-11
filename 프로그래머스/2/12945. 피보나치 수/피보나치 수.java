class Solution {
    
    int[] memo = new int[100_001];
    
    public int solution(int n) {
        
        return fibo(n);
    }
    
    int fibo(int n) {
        if (n <= 1)
            return n;
        if (memo[n] == 0) {
            memo[n] = (fibo(n - 1) + fibo(n - 2)) % 1234567;
        }
        return memo[n];
    }
    
    
}