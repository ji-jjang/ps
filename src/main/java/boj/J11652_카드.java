package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class J11652_카드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Long> nums = new ArrayList<>(100_004);
        for (int i = 0; i < n; i++) {
            Long num = Long.parseLong(br.readLine());
            nums.add(num);
        }
        nums.sort((a, b) -> {
            return a.compareTo(b);
        });
        Long[] maxValue = new Long[]{nums.get(0), 0l}; // value, cnt
        long cnt = 1;
        for (int i = 1; i < n; i++) {
            if (nums.get(i).equals(nums.get(i - 1))) {
                ++cnt;
                if (cnt > maxValue[1])
                    maxValue = new Long[]{nums.get(i), cnt};
            } else {
                cnt = 1;
            }
        }
        System.out.println(maxValue[0]);
    }
}
