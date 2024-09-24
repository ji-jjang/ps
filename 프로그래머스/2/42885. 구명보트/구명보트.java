import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int l = 0;
        int r = people.length - 1;
        int ans = 0;
        while (l <= r) {
            int rest = limit - people[r];
            if (rest >= people[l])
                ++l;
            --r;
            ++ans;
        }
        return ans;
    }
}