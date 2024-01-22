package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class J14891_톱니바퀴 {
    static ArrayList<ArrayList<Integer>> wheel = new ArrayList<>();
    static int[] rotation = new int[7];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 4; ++i) {
            ArrayList<Integer> wheelRow = new ArrayList<>();
            String nums = br.readLine();
            for (var c : nums.toCharArray())
                wheelRow.add(c - '0');
            wheel.add(wheelRow);
        }
        int k = Integer.parseInt(br.readLine());
        while (k-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());
            Arrays.fill(rotation, 0);
            rotation[num] = dir;
            checkrotation(num, dir);
            for (int i = 0; i < 4; i++) {
                if (rotation[i] == 0) continue;
                Collections.rotate(wheel.get(i), rotation[i]);
            }
        }
        int score = 0;
        for (int i = 0; i < 4; i++) {
            if (wheel.get(i).get(0) == 1)
                score += 1 << i;
        }
        System.out.println(score);
        br.close();
    }

    static void checkrotation(int num, int direct) {
        int dir = direct;
        for (int left = num - 1; left >= 0; --left) {
            int cur = left + 1;
            if (wheel.get(left).get(2) != wheel.get(cur).get(6)) {
                dir *= -1;
                rotation[left] = dir;
            } else
                break;
        }
        dir = direct;
        for (int right = num + 1; right < 4; ++right) {
            int cur = right - 1;
            if (wheel.get(right).get(6) != wheel.get(cur).get(2)) {
                dir *= -1;
                rotation[right] = dir;
            } else
                break;
        }
    }
}
