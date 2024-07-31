import java.util.PriorityQueue;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a)); 
        
        int cnt = 0; 
        int i = 0; 
        for (; i < enemy.length; ++i) {
            if (n >= enemy[i]) {
                n -= enemy[i];
                pq.offer(enemy[i]);
            } else {
                if (cnt < k) {
                    if (!pq.isEmpty() && pq.peek() > enemy[i]) {
                        n += pq.poll() - enemy[i]; 
                        pq.offer(enemy[i]); 
                    }
                    ++cnt;
                } else {
                    break;
                }
            }
        }
        return i;
    }
}