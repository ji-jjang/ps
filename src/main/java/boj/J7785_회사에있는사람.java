package boj;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class J7785_회사에있는사람 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String[] log = br.readLine().split(" ");
            if (log[1].equals("enter")) {
                set.add(log[0]);
            } else {
                set.remove(log[0]);
            }
        }
        ArrayList<String> aList = new ArrayList<>(set);
        Collections.sort(aList, Collections.reverseOrder());
        for (String name : aList)
            bw.write(name + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
