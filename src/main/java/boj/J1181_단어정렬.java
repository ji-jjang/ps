package boj;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

public class J1181_단어정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        HashSet<String> wordSet = new HashSet<>(20000);
        for (int i = 0; i < n; i++)
            wordSet.add(br.readLine());
        ArrayList<String> words = new ArrayList<>(wordSet);
        words.sort((a, b) -> {
            if (a.length() != b.length())
                return a.length() - b.length();
            return a.compareTo(b);
        });
        for (var e : words)
            bw.write(e + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
