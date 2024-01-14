package boj;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class J5648_역원소정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Long> nums = new ArrayList<>(1_000_004);
        int n = Integer.parseInt(st.nextToken());
        int cnt = 0;
        while (true) {
            while (st.hasMoreTokens()) {
                String num = st.nextToken();
                nums.add(Long.parseLong(num));
                ++cnt;
            }
            if (cnt == n)
                break;
            st = new StringTokenizer(br.readLine());
        }
        for (int i = 0; i < nums.size(); i++) {
            long cur = nums.get(i);
            long result = 0;
            while (cur != 0)  {
                result *= 10;
                result += cur % 10;
                cur /= 10;
            }
            nums.set(i, result);
        }
        nums.sort((a, b) -> {
            return a.compareTo(b);
        });
        for (var e : nums)
            bw.write(e + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
