class Solution {
    public String solution(String my_string, int[] index_list) {
        
        StringBuilder sb = new StringBuilder();
        
        char[] str = my_string.toCharArray();
        for (var e : index_list) {
            sb.append(str[e]);
        }
    
        return sb.toString();
    }
}