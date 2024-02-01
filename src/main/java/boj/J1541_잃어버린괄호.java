package boj;

import java.util.Scanner;

public class J1541_잃어버린괄호 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int sign = 1;
        int ans = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : line.toCharArray()) {
            if (c == '-' || c == '+') {
                ans += sign * Integer.parseInt(sb.toString());
                sb.setLength(0);
                if (c == '-')
                    sign = -1;
                continue;
            }
            sb.append(c);
        }
        ans += sign * Integer.parseInt(sb.toString());
        System.out.println(ans);
        sc.close();
    }
}
