class Solution {
    public String solution(String my_string, int n) {
        
        int st = my_string.length() - n;
        StringBuilder sb = new StringBuilder();
        char[] str = my_string.toCharArray();
        for (int i = st; i < my_string.length(); ++i) {
            sb.append(str[i]);
        }
        return sb.toString();
    }
}