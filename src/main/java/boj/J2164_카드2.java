package boj;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class J2164_카드2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++)
            q.add(i);
        while (q.size() > 1) {
            q.poll();
            q.add(q.poll());
        }
        System.out.println(q.peek());
        int[] arr = new int[100];
        Arrays.sort(arr);
    }
}
