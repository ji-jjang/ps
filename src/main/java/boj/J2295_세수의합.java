package main.java.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class J2295_세수의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] u = new int[N];
        for (int i = 0; i < N; i++) {
            u[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(u);
        ArrayList<Integer> Two = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                Two.add(u[i] + u[j]);
            }
        }
        Collections.sort(Two);
        for (int i = N - 1; i > 0; --i) {
            for (int j = 0; j < i; ++j) {
                int key = u[i] - u[j];
                if (Collections.binarySearch(Two, key) >= 0) {
                    System.out.println(u[i]);
                    return ;
                }
            }
        }
    }
}
