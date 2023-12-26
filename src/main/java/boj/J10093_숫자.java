package boj;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class J10093_숫자 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long a = sc.nextLong();
        long b = sc.nextLong();
        if (a > b) {
            long temp = a;
            a = b;
            b = temp;
        }
        long count = (b - a - 1) < 0 ? 0 : (b - a - 1);
        bw.write(count + "\n");
        for (long i = a + 1; i < b; ++i) {
            bw.write(i + " ");
        }
        bw.flush();
        bw.close();
    }
}
