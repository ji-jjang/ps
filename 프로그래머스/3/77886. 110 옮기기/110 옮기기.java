import java.util.*;

class Solution {
    public String[] solution(String[] s) {
        String[] ans = new String[s.length];
        
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for (var str : s) {
            int oozCnt = 0;
            for (int i = 0; i < str.length(); ++i) {
                sb.append(str.charAt(i));
                if (sb.length() >= 3 && sb.substring(sb.length() - 3).equals("110")) {
                    ++oozCnt;
                    sb.setLength(sb.length() - 3);
                }
            }
            int pos = sb.lastIndexOf("0") + 1;
            if (pos == 0) pos = 0;
            while (--oozCnt >= 0) {
                sb.insert(pos, "110");
            }
            ans[idx++] = sb.toString();
            sb.setLength(0);
        }        
        return ans;
    }
}