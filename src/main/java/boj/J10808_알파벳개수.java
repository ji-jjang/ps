package boj;

import java.util.Scanner;

public class J10808_알파벳개수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int[] alpha = new int[26];
        for (char c : line.toCharArray()) {
            alpha[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            System.out.printf("%d ", alpha[i]);
        }
    }
}
