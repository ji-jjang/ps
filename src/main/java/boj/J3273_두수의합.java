package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class J3273_두수의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] isChecked = new boolean[2_000_001];
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(br.readLine());
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            a[i] = num;
            if (x - a[i] > 0 && isChecked[x - a[i]])
                ++ans;
            isChecked[num] = true;
        }
        System.out.println(ans);
    }
}
// 정렬을 하고 반만돌아야하나?
// n이 10만이므로 nlogn, n 알고리즘
// 바로 입력과 동시에 처리하면 중복처리가 되는구나...
