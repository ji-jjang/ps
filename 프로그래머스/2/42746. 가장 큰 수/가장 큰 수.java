import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        List<String> nums = new ArrayList<>();
        for (var e : numbers)
            nums.add(Integer.toString(e));
        nums.sort((a, b) -> (b + a).compareTo(a + b));
        if (nums.get(0).equals("0"))
            return "0";

        StringBuilder sb = new StringBuilder();
        for (var e : nums)
            sb.append(e);
        return sb.toString();
    }
}