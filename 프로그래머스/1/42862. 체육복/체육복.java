import java.util.*;

// 1. n번 학생은 체육복 한 벌씩 있음(index, 여벌 갯수)
// 2. lost 학생은 체육복 한 벌씩 제거
// 3. reserve 학생은 체육복 한 벌씩 추가
// 3. 체육복이 없는 학생은 (자신의 번호 - 1, + 1) 학생이 체육복이 2벌 있다면 체육복 빌림
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 1; i <= n; ++i) 
            m.put(i, m.getOrDefault(i, 0) + 1);
        for (var e : lost) {
            if (m.containsKey(e))
                m.put(e, m.get(e) - 1);
        }
        for (var e : reserve) {
            if (m.containsKey(e)) {
                m.put(e, m.get(e) + 1);
            }
        }
        int cnt = 0;
        for (int i = 1; i <= n; ++i) {
            if (m.get(i) < 1) {
                if (m.containsKey(i - 1) && m.get(i - 1) > 1) {
                    m.put(i - 1, m.get(i - 1) - 1);
                    m.put(i, m.get(i) + 1);
                    ++cnt;
                }
                else if (m.containsKey(i + 1) && m.get(i + 1) > 1) {
                    m.put(i + 1, m.get(i + 1) - 1);
                    m.put(i, m.get(i) + 1);
                    ++cnt;
                }
            }
            else
                ++cnt;
        }
        return cnt;
    }
}