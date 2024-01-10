package boj;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class J1620_나는야포켓몬마스터이다솜 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] i2s = new String[n + 4];
        HashMap<String, Integer> s2i = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String name = br.readLine();
            i2s[i] = name;
            s2i.put(name, i);
        }
        for (int i = 0; i < m; i++) {
            String q = br.readLine();
            if (q.charAt(0) >= '1' && q.charAt(0) <= '9')
                bw.write(i2s[Integer.parseInt(q)] + "\n");
            else
                bw.write(s2i.get(q) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
// i2s -> String
// s2i -> map
