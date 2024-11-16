class Solution {
    public int solution(int[] common) {
        int diff = common[1] - common[0];
        if (common[1] - common[0] == common[2] - common[1]) {
            return common[common.length - 1] + diff;
        }
        int ratio = common[1] / common[0];
        return common[common.length - 1] * ratio;
    }
}