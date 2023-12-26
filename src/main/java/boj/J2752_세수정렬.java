package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class J2752_세수정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);
        ArrayList<Integer> a = new ArrayList<>();
        a.add(Integer.parseInt(st.nextToken()));
        a.add(Integer.parseInt(st.nextToken()));
        a.add(Integer.parseInt(st.nextToken()));
        Collections.sort(a);
        for (int num : a) {
            System.out.println(num);
        }
        br.close();
    }
}
