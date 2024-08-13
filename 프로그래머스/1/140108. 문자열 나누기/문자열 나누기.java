class Solution {
    public int solution(String s) {
        
        char[] str = s.toCharArray();
        
        int i = 0;
        int ans = 0;
        while (i < str.length) {
            char cur = str[i];
            int curCnt = 1;
            int j = i + 1;
            for (; j < str.length; ++j) {
                if (cur == str[j])
                    ++curCnt;
                else
                    break;
            }
            for (; j < str.length; ++j) {
                if (cur != str[j]) --curCnt;
                else
                    ++curCnt;
                if (curCnt == 0) break;
            }
            i += j - i + 1;
            ++ans;
        }
        return ans;
    }
}