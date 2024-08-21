class Solution {
    public int solution(String s) {

        int ans = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= s.length() / 2; i++) {
            sb.setLength(0);
            String tmp = s.substring(0, i);
            int cnt = 1;
            for (int j = i; j < s.length(); j += i) {
                String nxt = s.substring(j, Math.min(j + i, s.length()));
                if (tmp.equals(nxt)) {
                    ++cnt;
                } else {
                    if (cnt > 1) {
                        sb.append(cnt);
                        sb.append(tmp);
                    } else {
                        sb.append(tmp);
                    }
                    tmp = nxt;
                    cnt = 1;
                }
            }
            if (cnt != 1) {
                sb.append(cnt);
                sb.append(tmp);
                tmp = "";
            }
            sb.append(tmp);
            ans = Math.min(ans, sb.length());
        }
        return ans;
    }
}