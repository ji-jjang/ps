package boj;

import java.util.Scanner;

public class J2438_별찍기5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 1; i <= N; ++i) {
            for (int j = N; j > i; --j) {
                System.out.printf(" ");
            }
            for (int j = 1; j <= 2 * i - 1; ++j) {
                System.out.printf("*");
            }
            System.out.println();
        }
    }
}
