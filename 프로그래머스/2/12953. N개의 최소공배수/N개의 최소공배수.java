class Solution {
    public int solution(int[] arr) {
        if (arr.length == 1) 
            return arr[0];
        
        int lcm = lcm(arr[0], arr[1]);
        for (int i = 2; i < arr.length; ++i) {
            lcm = lcm(lcm, arr[i]);
        }
        return lcm;
    }
    
    int gcd(int a, int b) {
		if (a == 0)
			return b;
		return gcd(b % a, a);
    }
    
    int lcm(int a, int b) {
		return a / gcd(a, b) * b;
    }
}