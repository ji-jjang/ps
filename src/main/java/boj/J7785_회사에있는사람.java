package boj;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class J7785_회사에있는사람 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        HashSet<String> hs = new HashSet<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken(); String log = st.nextToken();
            if ("enter".equals(log)) hs.add(name);
            else hs.remove(name);
        }
        ArrayList<String> list = new ArrayList<>(hs);
        Collections.sort(list, (a, b) -> b.compareTo(a));
        for (var e : list)
            bw.write(e + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
