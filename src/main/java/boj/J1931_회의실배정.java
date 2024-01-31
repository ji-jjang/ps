package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class J1931_회의실배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<int[]> meets = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] nums = new int[2];
            nums[0]= Integer.parseInt(st.nextToken());
            nums[1]= Integer.parseInt(st.nextToken());
            meets.add(nums);
        }
        meets.sort((a, b) -> {
            if (a[1] == b[1])
                return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });
        int now = 0;
        int ans = 0;
        for (var e : meets) {
            if (now <= e[0]) {
                now = e[1];
                ++ans;
            }
        }
        System.out.println(ans);
        br.close();
    }
}
