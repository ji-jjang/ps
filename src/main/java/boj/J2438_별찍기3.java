package boj;

import java.util.Scanner;

public class J2438_별찍기3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 1; i <= N; ++i) {
            for (int j = N; j >= i; --j) {
                System.out.printf("*");
            }
            System.out.println();
        }
    }
}
