class Solution {
    public String solution(String my_string) {
        
        StringBuilder sb = new StringBuilder();
        for (char c : my_string.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                sb.append((char)(c - 'a' + 'A'));
            } else {
                sb.append((char)(c - 'A' + 'a'));
            }
        }
        return sb.toString();
    }
}