class Solution {
    public int solution(int[] num_list) {
        StringBuilder odds = new StringBuilder();
        StringBuilder evens = new StringBuilder();
        for (var e : num_list) {
            if (e % 2 == 0) {
                evens.append(e);
            }
            else {
                odds.append(e);
            }
        }
        
        return Integer.parseInt(evens.toString()) + Integer.parseInt(odds.toString());
    }
}