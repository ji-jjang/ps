package boj;

import java.util.Scanner;

public class J2753_윤년 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();

        boolean isLeapyear = false;
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
           isLeapyear = true;
        }
        int result = isLeapyear == true ? 1 : 0;
        System.out.println(result);
    }
}
