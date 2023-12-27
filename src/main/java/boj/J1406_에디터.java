package boj;

import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class J1406_에디터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        LinkedList<Character> L = new LinkedList<>();
        String line = br.readLine();
        for (char c : line.toCharArray()) {
            L.add(c);
        }
        ListIterator<Character> cursor = L.listIterator();
        while (cursor.hasNext()) {
            cursor.next();
        }
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char op = st.nextToken().toCharArray()[0];
            if (op == 'L') {
                if (cursor.hasPrevious())
                    cursor.previous();
            } else if (op == 'D') {
                if (cursor.hasNext())
                    cursor.next();
            } else if (op == 'B') {
                if (cursor.hasPrevious()) {
                    cursor.previous();
                    cursor.remove();
                }
            } else {
                char ch;
                ch = st.nextToken().toCharArray()[0];
                cursor.add(ch);
            }
        }
        for (char c : L)
            bw.write(c);
        bw.flush();
        bw.close();
        br.close();
    }
}
