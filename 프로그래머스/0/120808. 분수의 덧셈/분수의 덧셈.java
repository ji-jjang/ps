class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        
        int denom = denom1 * denom2;
        int number = (numer1 * denom2) + (numer2 * denom1);
        int gcd = gcd(denom, number);
            
        return new int[] {number / gcd, denom / gcd};
    }
    
    int gcd(int a, int b) {
        
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}