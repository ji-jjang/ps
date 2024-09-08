class Solution {
    public int solution(int a, int b) {
        StringBuilder sum1 = new StringBuilder();
        StringBuilder sum2 = new StringBuilder();
        
        specialPlus(sum1, a);
        specialPlus(sum1, b);
        specialPlus(sum2, b);
        specialPlus(sum2, a);
        
        int ret1 = Integer.parseInt(sum1.toString());
        int ret2 = Integer.parseInt(sum2.toString());
        int ans = ret1;
        if (ret1 < ret2) 
            ans = ret2;
        return ans;
    }
    
    void specialPlus(StringBuilder origin, int num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % 10);
            num /= 10;
        }
        sb.reverse();
        origin.append(sb);
    }
}