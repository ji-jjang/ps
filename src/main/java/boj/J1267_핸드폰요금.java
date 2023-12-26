package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class J1267_핸드폰요금 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int Y = 0;
        int M = 0;
        for (int i = 0; i < N; i++) {
            int charge = Integer.parseInt(st.nextToken());
            Y += 10 + charge / 30 * 10;
            M += 15 + charge / 60 * 15;
        }
        if (Y > M) {
            System.out.printf("M %d", M);
        } else if (Y < M) {
            System.out.printf("Y %d", Y);
        } else {
            System.out.printf("Y M %d", Y);
        }
        br.close();
    }
}
