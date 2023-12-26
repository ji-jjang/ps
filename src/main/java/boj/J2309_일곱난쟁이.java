package boj;

import java.io.*;
import java.util.Arrays;

public class J2309_일곱난쟁이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] dwarf = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            dwarf[i] = Integer.parseInt(br.readLine());
            sum += dwarf[i];
        }
        Arrays.sort(dwarf);
        for (int i = 0; i < 8; ++i) {
            for (int j = i + 1; j < 9; ++j) {
                sum -= dwarf[i];
                sum -= dwarf[j];
                if (sum == 100) {
                    for (int k = 0; k < 9; k++) {
                        if (k == i || k == j) {
                            continue ;
                        }
                        bw.write(dwarf[k] + "\n");
                    }
                    bw.flush();
                    bw.close();
                    br.close();
                    return ;
                }
                sum += dwarf[i];
                sum += dwarf[j];
            }
        }
    }
}
