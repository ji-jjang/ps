package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class J2217_로프 {
    static ArrayList<Integer> r = new ArrayList<>(100_004);
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++)
            r.add(Integer.parseInt(br.readLine()));
        r.sort((a, b) -> Integer.compare(a, b));
        int mx = r.get(r.size() - 1);
        for (int i = 0; i < n; i++)
            mx = Math.max(mx, r.get(i) * (n - i));
        System.out.println(mx);
        br.close();
    }
}
