class Solution {
    public long solution(int w, int h) {
        
        long ans = 0;
        for (int i = 0; i < w; i++) {
            ans += 1L * i * h / w ;
        }
        return ans * 2;
    }
}