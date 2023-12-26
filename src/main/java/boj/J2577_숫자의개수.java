package boj;

import java.util.Scanner;

public class J2577_숫자의개수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = sc.nextInt() * sc.nextInt() * sc.nextInt();
        int[] digits = new int[10];
        while (result != 0) {
            digits[result % 10]++;
            result /= 10;
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(digits[i]);
        }
    }
}
