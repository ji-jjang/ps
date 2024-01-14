package boj;

import java.io.*;
import java.util.ArrayList;

public class J1431_시리얼번호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        ArrayList<String> nums = new ArrayList<>(50);
        for (int i = 0; i < n; i++)
            nums.add(br.readLine());
        nums.sort((a, b) -> {
            if (a.length() != b.length())
                return Integer.compare(a.length(), b.length());
            int sumA = findSum(a);
            int sumB = findSum(b);
            if (sumA != sumB)
                return Integer.compare(sumA, sumB);
            return a.compareTo(b);
        });
        for (var e : nums)
            bw.write(e + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int findSum(String str) {
        int ret = 0;
        for (var c : str.toCharArray()) {
            if (c >= '0' && c <= '9')
                ret += c - '0';
        }
        return ret;
    }
}
