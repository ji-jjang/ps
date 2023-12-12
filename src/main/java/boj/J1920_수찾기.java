package main.java.boj;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class J1920_수찾기 {
    static int N, M;
    static ArrayList<Integer> A = new ArrayList<>(100_000);
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        String[] numbers = br.readLine().split(" ");
        for (int i = 0; i < N; ++i) {
            A.add(Integer.parseInt(numbers[i]));
        }
        Collections.sort(A);
        M = Integer.parseInt(br.readLine());
        String[] needles = br.readLine().split(" ");
        for (int i = 0; i < M; ++i) {
            int needle = Integer.parseInt(needles[i]);
            bw.write(bsearch(needle) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static int bsearch(int needle) {
        int st = 0;
        int en = N - 1;

        while (st <= en) {
            int mid = (st + en) / 2;
            if (A.get(mid) < needle) {
                st = mid + 1;
            } else if (A.get(mid) > needle) {
                en = mid - 1;
            } else {
                return 1;
            }
        }
        return 0;
    }
}