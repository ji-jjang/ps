class Solution {
    public int solution(int angle) {
        if (angle < 90)
            return 1;
        if (angle < 91)
            return 2;
        if (angle < 180)
            return 3;
        return 4;
    }
}