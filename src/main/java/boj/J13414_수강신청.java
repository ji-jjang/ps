package boj;

import java.io.*;
import java.util.*;

public class J13414_수강신청 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 1; i <= l; i++) {
            String id = br.readLine();
            hm.put(id, i);
        }
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(hm.entrySet());
        Collections.sort(list, (a, b) -> a.getValue().compareTo(b.getValue()));
        int count = 0;
        for (Map.Entry<String, Integer> entry : list) {
            if (count == k) break;
            bw.write(entry.getKey() + "\n");
            count++;
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
