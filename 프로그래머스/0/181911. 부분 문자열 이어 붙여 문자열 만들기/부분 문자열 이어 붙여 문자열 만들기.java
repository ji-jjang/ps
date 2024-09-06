class Solution {
    public String solution(String[] my_strings, int[][] parts) {
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < my_strings.length; ++i) {
            char[] str = my_strings[i].toCharArray();
            for (int j = parts[i][0]; j <= parts[i][1]; ++j) {
                sb.append(str[j]);
            }
        }
        return sb.toString();
    }
}