class Solution {
    public int solution(int a, int b) {
        
        StringBuilder sb = new StringBuilder();
        spacialPlus(sb, a);
        spacialPlus(sb, b);
        
        int ans = Integer.parseInt(sb.toString());
        if (ans < 2 * a * b)
            ans = 2 * a * b;
        
        return ans;
    }
    void spacialPlus(StringBuilder origin, int num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % 10);
            num /= 10;
        }
        sb.reverse();
        origin.append(sb);
    }
    
}