class Solution {
    public int solution(int[] num_list) {
        int multSum = 1;
        int sum = 0;
        for (var e : num_list) {
            multSum *= e;
            sum += e;
        }
        return multSum < sum * sum ? 1 : 0;
    }
}