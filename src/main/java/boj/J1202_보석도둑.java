package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeMap;

public class J1202_보석도둑 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        Pair[] jewels = new Pair[N];

        for (int i = 0; i < N; i++) {
            String[] info = br.readLine().split(" ");
            int m = Integer.parseInt(info[0]);
            int v = Integer.parseInt(info[1]);
            jewels[i] = new Pair(m, v);
        }
        Arrays.sort(jewels);
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(br.readLine());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        long ans = 0;
        for (int i = N - 1; i >= 0; --i) {
            Integer bagWeight = map.ceilingKey(jewels[i].weight);
            if (bagWeight != null) {
                ans += jewels[i].value;
                if (map.get(bagWeight) == 1) {
                    map.remove(bagWeight);
                } else {
                    map.put(bagWeight, map.get(bagWeight) - 1);
                }
            }
        }
        System.out.println(ans);
    }
    static class Pair implements Comparable<Pair> {
        int weight;
        int value;

        Pair(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.value != other.value)
                return this.value - other.value;
            return this.weight - other.weight;
        }
    }
}

