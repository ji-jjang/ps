import java.util.Arrays;
class Solution {
    public int solution(int[] array) {
        return (int)Arrays.stream(array).mapToObj(String::valueOf).flatMapToInt(s -> s.chars()).mapToObj(c -> (char) c).filter(ch -> ch == '7').count();
    }
}