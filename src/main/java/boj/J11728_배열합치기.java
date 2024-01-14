package boj;

import java.io.*;
import java.util.StringTokenizer;

public class J11728_배열합치기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        int[] b = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++)
            b[i] = Integer.parseInt(st.nextToken());
        int l = 0, r = 0;
        for (int i = 0; i < n + m; ++i) {
            if (l == n)
                bw.write(b[r++] + " ");
            else if (r == m)
                bw.write(a[l++] + " ");
            else if (a[l] < b[r])
                bw.write(a[l++] + " ");
            else
                bw.write(b[r++] + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
