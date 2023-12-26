package boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class J2587_대표값2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> a = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            int num = sc.nextInt();
            a.add(num);
            sum += num;
        }
        Collections.sort(a);
        System.out.println(sum / 5);
        System.out.println(a.get(2));
    }
}
