package boj;

import java.io.*;
import java.util.TreeMap;

public class J7662_이중우선순위큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int j = 0; j < k; j++) {
                String[] input = br.readLine().split(" ");
                int num = Integer.parseInt(input[1]);
                if (input[0].charAt(0) == 'I') {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                } else {
                    if (map.isEmpty()) {
                        continue;
                    } else {
                        int n = (num == 1) ? map.lastKey() : map.firstKey();
                        if (map.put(n, map.get(n) - 1) == 1)
                            map.remove(n);
                    }
                }
            }
            if (map.isEmpty())
                bw.write("EMPTY\n");
            else
                bw.write(map.lastKey() + " " + map.firstKey() + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
