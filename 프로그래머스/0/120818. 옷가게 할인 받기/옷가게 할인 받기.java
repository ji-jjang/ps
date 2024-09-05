class Solution {
    public int solution(int price) {
        if (price < 100_000)
            return price;
        if (price < 300_000)
            return (int)(price * 0.95);
        if (price < 500_000)
            return (int)(price * 0.9);
        return (int)(price * 0.8);
    }
}