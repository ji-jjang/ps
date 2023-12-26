package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class J2480_주사위세개 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < 3; ++i) {
            a.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(a);
        int reward = 0;
        if (a.get(0) == a.get(1) && a.get(1) == a.get(2)) {
            reward = 10000 + a.get(2) * 1000;
        } else if (a.get(0) == a.get(1) || a.get(0) == a.get(2)) {
            reward = 1000 + a.get(1) * 100;
        } else if (a.get(1) == a.get(2)) {
            reward = 1000 + a.get(2) * 100;
        } else {
            reward = a.get(2) * 100;
        }
        System.out.println(reward);
        br.close();
    }
}
