class Solution {
    public int solution(int hp) {
        int a = hp / 5;
        hp %= 5;
        int b = hp / 3;
        hp %= 3;
        return a + b + hp;
    }
}