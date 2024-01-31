package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class J11399_ATM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> t = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            t.add(Integer.parseInt(st.nextToken()));
        t.sort((a, b) -> Integer.compare(a, b));
        int ans = 0;
        for (int i = 0; i < n; i++)
            ans += t.get(i) * (n - i);
        System.out.println(ans);
    }
}
