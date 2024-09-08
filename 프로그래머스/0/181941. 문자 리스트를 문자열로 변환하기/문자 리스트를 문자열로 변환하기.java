class Solution {
    public String solution(String[] arr) {
        
        StringBuilder sb = new StringBuilder();
        for (var str : arr) {
            for (var c : str.toCharArray()) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}