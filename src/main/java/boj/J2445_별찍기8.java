package boj;

import java.util.Scanner;

public class J2445_별찍기8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf("*");
            }
            for (int j = N; j > i; --j) {
                System.out.printf(" ");
                System.out.printf(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.printf("*");
            }
            System.out.println();
        }
        for (int i = N - 1; i >= 1; --i) {
            for (int j = i; j >= 1; --j) {
                System.out.printf("*");
            }
            for (int j = 1; j <= N - i; ++j) {
                System.out.printf(" ");
                System.out.printf(" ");
            }
            for (int j = i; j >= 1; --j) {
                System.out.printf("*");
            }
            System.out.println();
        }
    }
}
