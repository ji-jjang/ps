package boj;

import java.io.*;
import java.util.ArrayList;

public class J2751_수정렬하기2 {
    static ArrayList<Integer> tmp = new ArrayList<>(1_000_000);
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> a = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            a.add(Integer.parseInt(br.readLine()));
            tmp.add(0);
        }
        mergeSort(a, 0, n);
        for (int i = 0; i < n; i++)
            bw.write(a.get(i) + " ");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void mergeSort(ArrayList<Integer> a, int st, int en) {
        if (en - st <= 1)
            return ;
        int mid = (st + en) / 2;
        mergeSort(a, st, mid);
        mergeSort(a, mid, en);
        merge(a, st, en);
    }

    private static void merge(ArrayList<Integer> a, int st, int en) {
        int mid = (st + en) / 2;
        int l = st, r = mid;
        for (int i = st; i < en; i++) {
            if (l == mid)
                tmp.set(i, a.get(r++));
            else if (r == en)
                tmp.set(i, a.get(l++));
            else if (a.get(l) < a.get(r))
                tmp.set(i, a.get(l++));
            else
                tmp.set(i, a.get(r++));
        }
        for (int i = st; i < en; i++)
            a.set(i, tmp.get(i));
    }
}
