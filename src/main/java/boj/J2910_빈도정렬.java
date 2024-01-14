package boj;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class J2910_빈도정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> firstIndexMap = new HashMap<>();
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            firstIndexMap.putIfAbsent(num, i);
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(countMap.entrySet());
        list.sort((a, b) -> {
            if (!a.getValue().equals(b.getValue()))
                return b.getValue() - a.getValue();
            return firstIndexMap.get(a.getKey()) - firstIndexMap.get(b.getKey());
        });
        for (var e : list) { for (int i = 0; i < e.getValue(); i++) { bw.write(e.getKey() + " "); } } bw.flush(); bw.close(); br.close(); }
}
