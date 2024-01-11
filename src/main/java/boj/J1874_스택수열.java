package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class J1874_스택수열 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> s = new Stack<>();
        int maxNum = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            for (int j = maxNum + 1; j <= num; j++) {
                s.push(j);
                sb.append("+\n");
            }
            maxNum = Math.max(maxNum, num);
            if (!s.isEmpty() && s.peek() != num) {
                System.out.println("NO");
                return ;
            }
            s.pop();
            sb.append("-\n");
        }
        System.out.println(sb.toString());
    }
}
