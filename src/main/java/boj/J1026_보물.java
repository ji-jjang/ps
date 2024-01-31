package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class J1026_보물 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            a.add(Integer.parseInt(st.nextToken()));
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            b.add(Integer.parseInt(st.nextToken()));
        a.sort((e1, e2) -> Integer.compare(e1, e2));
        b.sort((e1, e2) -> Integer.compare(e1, e2));
        int ans = 0;
        for (int i = 0; i < n; i++)
            ans += a.get(i) * b.get(n - 1 - i);
        System.out.println(ans);
        br.close();
    }
}
