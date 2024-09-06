class Solution {
    public String solution(String cipher, int code) {
        char[] chars = cipher.toCharArray();
        StringBuilder sb = new StringBuilder();
        
        int init = code - 1;
        for (int i = init; i < chars.length; i += code) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }
}