package boj;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class J1475_방번호 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int N = sc.nextInt();
        int[] digits = new int[10];
        while (N != 0) {
            digits[N % 10]++;
            N /= 10;
        }
        int sum = digits[6] + digits[9];
        digits[6] = sum > 0 ? (sum % 2 + sum / 2) : 0;
        digits[9] = 0;
        Arrays.sort(digits);
        System.out.println(digits[9]);
    }
}
