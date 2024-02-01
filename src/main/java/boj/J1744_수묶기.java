package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class J1744_수묶기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int zero = 0;
        int one = 0;
        ArrayList<Integer> neg = new ArrayList<>();
        ArrayList<Integer> pos = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num < 0)
                neg.add(num);
            else if (num == 0)
                ++zero;
            else if (num == 1)
                ++one;
            else
                pos.add(num);
        }
        neg.sort((a, b) -> Integer.compare(b, a));
        pos.sort((a, b) -> Integer.compare(a, b));
        int ans = 0;
        while (neg.size() > 1) {
            ans += neg.get(neg.size() - 1) * neg.get(neg.size() - 2);
            neg.remove(neg.size() - 1);
            neg.remove(neg.size() - 1);
        }
        if (neg.size() > 0) {
            if (zero == 0)
                ans += neg.get(0);
        }
        while (pos.size() > 1) {
            ans += pos.get(pos.size() - 1) * pos.get(pos.size() - 2);
            pos.remove(pos.size() - 1);
            pos.remove(pos.size() - 1);
        }
        if (pos.size() > 0)
            ans += pos.get(0);
        ans += one;
        System.out.println(ans);
        br.close();
    }
}
