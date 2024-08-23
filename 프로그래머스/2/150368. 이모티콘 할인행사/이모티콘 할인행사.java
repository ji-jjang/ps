class Solution {
    int maxSubs = 0;
    int maxSales = 0;

    public int[] solution(int[][] users, int[] emoticons) {
        int[] discounts = {10, 20, 30, 40};
        dfs(0, new int[emoticons.length], discounts, emoticons, users);
        return new int[]{maxSubs, maxSales};
    }

    void dfs(int depth, int[] selected, int[] discounts, int[] emoticons, int[][] users) {
        if (depth == emoticons.length) {
            calculate(depth, selected, discounts, emoticons, users);
            return;
        }

        for (var discount : discounts) {
            selected[depth] = discount;
            dfs(depth + 1, selected, discounts, emoticons, users);
        }
    }

    void calculate(int depth, int[] selected, int[] discounts, int[] emoticons, int[][] users) {
        int subs = 0;
        int sales = 0;

        for (var user : users) {
            int userDiscount = user[0];
            int userPrice = user[1];
            int ret = 0;

            for (int i = 0; i < depth; i++) {
                if (selected[i] >= userDiscount) {
                    ret += emoticons[i] * (100 - selected[i]) / 100;
                }
            }

            if (ret >= userPrice) {
                ++subs;
            } else {
                sales += ret;
            }
        }
        if (maxSubs < subs) {
            maxSubs = subs;
            maxSales = sales;
        } else if (maxSubs == subs) {
            maxSales = Math.max(maxSales, sales);
        }
    }
}
