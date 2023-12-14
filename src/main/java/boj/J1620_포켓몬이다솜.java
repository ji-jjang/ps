package boj;

import java.io.*;
import java.util.HashMap;

public class J1620_포켓몬이다솜 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        String[] i2s = new String[n + 1];
        HashMap<String, Integer> s2i = new HashMap<>();
        for (int i = 1; i <= n; ++i) {
            i2s[i] = br.readLine();
            s2i.put(i2s[i], i);
        }
        for (int i = 0; i < m; ++i) {
            String key = br.readLine();
            if (key.charAt(0) >= '0' && key.charAt(0) <= '9') {
                bw.write(i2s[Integer.parseInt(key)] + "\n");
            } else {
                bw.write(s2i.get(key) + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
