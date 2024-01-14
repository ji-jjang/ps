package boj;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class J11650_좌표정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        ArrayList<int []> coord = new ArrayList<>(100_000);
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            coord.add(new int[]{x, y});
        }
        coord.sort((a, b) -> {
            if (a[0] == b[0])
                return a[1] - b[1];
            return a[0] - b[0];
        });
        for (int i = 0; i < n; i++)
            bw.write(coord.get(i)[0] + " " + coord.get(i)[1] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
